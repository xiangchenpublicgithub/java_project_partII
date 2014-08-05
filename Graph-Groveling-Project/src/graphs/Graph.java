	package graphs;
	
	import java.util.*;
	/**
	
	* Implements a graph. We use two maps: one map for adjacency properties
	
	* (adjancencyMap) and one map (dataMap) to keep track of the data associated
	
	* with a vertex.
	
	*
	
	* @author cmsc132
	
	*
	
	* @param <E>
	
	*/
	
	public class Graph<E> {
	
	/* You must use the following maps in your implementation */
	
	private HashMap<String, HashMap<String, Integer>> adjacencyMap;
	
	private HashMap<String, E> dataMap;
	
	private int numVertices;
	
	private int numEdges;
	
	private class Vertex {
	
	int distance;
	
	boolean discovered;
	
	boolean processed;
	
	Vertex predecessor;
	
	private Vertex() {
	
	distance = Integer.MAX_VALUE;
	
	discovered = false;
	
	processed = false;
	
	predecessor = null;
	
	}
	
	public void clear() {
	
	distance = Integer.MAX_VALUE;
	
	discovered = false;
	
	processed = false;
	
	predecessor = null;
	
	}
	
	}
	
	private HashMap<String, Vertex> statusMap;
	
	// EMPTY_SET is a constant:
	
	//private static final HashMap<String, Integer> EMPTY_SET = new HashMap<String, Integer>();
	
	//private final Vertex EMPTY_VERTEX = new Vertex();
	
	public Graph() {
	
	adjacencyMap = new HashMap<String, HashMap<String, Integer>>();
	
	dataMap = new HashMap<String, E>();
	
	statusMap = new HashMap<String, Vertex>();
	
	numVertices = 0;
	
	numEdges = 0;
	
	}
	
	public void addVertex(String vertexName, E data) {
	
	if (dataMap.containsKey(vertexName))
	
	throw new IllegalArgumentException();
	
	else {
	
	dataMap.put(vertexName, data);
	
	adjacencyMap.put(vertexName, new HashMap<String, Integer>());
	
	statusMap.put(vertexName, new Vertex());
	
	numVertices ++;
	
	}
	
	}
	
	public void addDirectedEdge(String startVertexName,
	
	String endVertexName, int cost) {
	
	if (!dataMap.containsKey(startVertexName) ||
	
	!dataMap.containsKey(endVertexName))
	
	throw new IllegalArgumentException();
	
	else {
	
	adjacencyMap.get(startVertexName).put(endVertexName, cost);
	
	numEdges ++;
	
	}
	
	}
	
	public String toString() {
	
	StringBuilder str = new StringBuilder();
	
	str.append("Vertices: [");
	
	SortedSet<String> keys = new TreeSet<String>(dataMap.keySet());
	
	for (String key : keys)
	
	str.append(key + ", ");
	
	str = str.deleteCharAt(str.length()-1);
	
	str = str.deleteCharAt(str.length()-1);
	
	str.append("]\n");
	
	str.append("Edges:\n");
	
	for (String key : keys) {
	
	str.append("Vertex(" + key + ")--->{");
	
	SortedSet<String> adkeys = new TreeSet<String>(adjacencyMap.get(key).keySet());
	
	for (String adkey : adkeys)
	
	str.append(adkey + "=" + getCost(key,adkey) + ", ");
	
	if (adkeys.size()>0) {
	
	str = str.deleteCharAt(str.length()-1);
	
	str = str.deleteCharAt(str.length()-1);
	
	}
	
	str.append("}\n");
	
	}
	
	str = str.deleteCharAt(str.length()-1);
	
	return str.toString();
	
	}
	
	public Map<String,Integer> getAdjacentVertices(String vertexName) {
	
	if (!dataMap.containsKey(vertexName))
	
	throw new IllegalArgumentException();
	
	else
	
	return adjacencyMap.get(vertexName);
	
	}
	
	public int getCost(String startVertexName, String endVertexName) {
	
	if (!dataMap.containsKey(startVertexName) ||
	
	!dataMap.containsKey(endVertexName))
	
	throw new IllegalArgumentException();
	
	else
	
	return adjacencyMap.get(startVertexName).get(endVertexName);
	
	}
	
	public Set<String> getVertices() {
	
	return dataMap.keySet();
	
	}
	
	public E getData(String vertexName) {
	
	if (!dataMap.containsKey(vertexName))
	
	throw new IllegalArgumentException();
	
	else
	
	return dataMap.get(vertexName);
	
	}
	
	private void initSearch() {
	
	for (Vertex v : statusMap.values())
	
	v.clear();
	
	}
	
	public void doDepthFirstSearch(String startVertexName,
	
	CallBack<E> callback) {
	
	if (!dataMap.containsKey(startVertexName))
	
	throw new IllegalArgumentException();
	
	else {
	
	initSearch();
	
	Vertex s = statusMap.get(startVertexName);
	
	s.distance = 0;
	
	s.discovered = true;
	
	Stack<String> qNames = new Stack<String>();
	
	qNames.push(startVertexName);
	
	while (!qNames.isEmpty()) {
	
	String vName = qNames.pop();
	
	callback.processVertex(vName, dataMap.get(vName));
	
	Vertex v = statusMap.get(vName);
	
	for (String wName : this.getAdjacentVertices(vName).keySet()) {
	
	Vertex w = statusMap.get(wName);
	
	if (!w.discovered) {
	
	w.distance = v.distance+1;
	
	w.discovered = true;
	
	w.predecessor = v;
	
	qNames.push(wName);
	
	}
	
	}
	
	statusMap.get(vName).processed = true;
	
	}
	
	}
	
	}
	
	public void doBreadthFirstSearch(String startVertexName,
	
	CallBack<E> callback) {
	
	if (!dataMap.containsKey(startVertexName))
	
	throw new IllegalArgumentException();
	
	else {
	
	initSearch();
	
	Vertex s = statusMap.get(startVertexName);
	
	s.distance = 0;
	
	s.discovered = true;
	
	Queue<String> qNames = new LinkedList<String>();
	
	qNames.add(startVertexName);
	
	while (!qNames.isEmpty()) {
	
	String vName = qNames.remove();
	
	callback.processVertex(vName, dataMap.get(vName));
	
	Vertex v = statusMap.get(vName);
	
	for (String wName : this.getAdjacentVertices(vName).keySet()) {
	
	Vertex w = statusMap.get(wName);
	
	if (!w.discovered) {
	
	w.distance = v.distance+1;
	
	w.discovered = true;
	
	w.predecessor = v;
	
	qNames.add(wName);
	
	}
	
	}
	
	statusMap.get(vName).processed = true;
	
	}
	
	}
	
	}
	
	public int doDijkstras(String startVertexName,
	
	String endVertexName,
	
	ArrayList<String> shortestPath) {
	
	if (!dataMap.containsKey(startVertexName) ||
	
	!dataMap.containsKey(endVertexName))
	
	throw new IllegalArgumentException();
	
	else {
	
	initSearch();
	
	Vertex s = statusMap.get(startVertexName);
	
	s.distance = 0;
	
	PriorityQueue<String> qNames = new PriorityQueue<String>();
	
	qNames.add(startVertexName);
	
	while (!qNames.isEmpty()) {
	
	String vName = qNames.poll();
	
	Vertex v = statusMap.get(vName);
	
	for (String wName : this.getAdjacentVertices(vName).keySet()) {
	
	Vertex w = statusMap.get(wName);
	
	int cost = getCost(vName, wName);
	
	int tempDistance = v.distance + cost;
	
	if (tempDistance < w.distance) {
	
	qNames.remove(wName);
	
	w.distance = tempDistance;
	
	w.predecessor = v;
	
	qNames.add(wName);
	
	}
	
	}
	
	}
	
	String vName = endVertexName;
	
	Vertex v = statusMap.get(vName);
	
	if (v.distance == Integer.MAX_VALUE) {
	
	shortestPath.add("None");
	
	return -1;
	
	}
	
	else {
	
	int totalCost = v.distance;
	
	do {
	
	vName = getVertexName(v);
	
	shortestPath.add(vName);
	
	v = v.predecessor;
	
	} while(!vName.equals(startVertexName));
	
	Collections.reverse(shortestPath);
	
	return totalCost;
	
	}
	
	}
	
	}
	
	public String getVertexName(Vertex v) {
	
	Set<String> sSet = statusMap.keySet();
	
	String vName = "";
	
	for (String Name : sSet)
	
	if (statusMap.get(Name).equals(v)) {
	
	vName = Name;
	
	break;
	
	}
	
	return vName;
	
	}
	
	}