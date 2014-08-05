package student_classes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
public class Bag implements Iterable { // note you will need to parameterize this class and

	HashMap <Object, Integer> mymap;

	/**
	 * Default (sole) constructor. Sets up internal data structures.
	 */
	public Bag() {
		
		mymap = new HashMap<Object, Integer>();

	}

	/* public interface */
	/**
	 * Adds ele (Type) to the bag. If ele was already in the Bag, then its
	 * internal count is incremented by 1; otherwise a new entry is made, 
	 * indicating that at least 1 ele exists in this Bag.
	 * @param ele
	 */
	public void add( Object ele ) { // replace Object with your Type variable
		
		if(mymap.containsKey(ele)) {	
			int value = mymap.get(ele);
			value++;
			mymap.put(ele, value);
		}else{
			mymap.put(ele, 1);

		}
	}
	/**
	 * Consider several possibilities here:
	 * If the <code>ele</code> isn't in the Bag, throw an Illegal State Exception.
	 * If only one <code>ele</code> exists in the Bag, then remove it.
	 * If more than one <code>ele</code> exists in the Bag, make whatever changes are
	 * necessary to indicate that one fewer <code>ele</code> now exists in the Bag.
	 * Note, how you do this will depend upon your internal data-structure.
	 * @param ele
	 */
	public void remove( Object ele ) { //replace Object with your Type
		if(!mymap.containsKey(ele)) throw new IllegalStateException();
		int value = mymap.get(ele);
		if(value == 1) mymap.remove(ele);
		else{
			value--;
			mymap.put(ele, value);
		}
		
	}
	/**
	 * Returns true if this Bag contains at least one copy of the <code>key</code>.
	 * @param ele
	 * @return
	 */
	public boolean contains( Object ele ) { // replace Object with your Type 
		return mymap.containsKey(ele);
	}
	/**
	 * Returns the number of occurrences of <code>ele</code> in the Bag; 
	 * returns 0 in the event that <code>ele</code> is not in Bag.
	 * @param ele
	 * @return
	 */
	public int count( Object ele ) { //replace Object with your Type
		int getcount = 0;
		if(mymap.get(ele) != null)getcount = mymap.get(ele);
		return getcount;
	}
	/**
	 * Return the keys as a Set---i.e., no duplicates, order-unimportant.
	 * Use this function to determine the number of unique entries in the
	 * Bag!
	 * @return
	 */
	public Set asSet() { // parameterize Set<> with your type
		return mymap.keySet();
	}
	/**
	 * The "size" of a bag is the cardinality of the multiset that it
	 * embodies. In English, that means that the size of your bag 
	 * must accumulate the multiplicities of each element. For
	 * example: suppose your Bag contains 
	 * 
	 * Key    Count
	 * ------------
	 * "A"     2
	 * "B"     3
	 * "C"     1
	 * 
	 * Then its size is 6.
	 * 
	 * @return
	 */
	public int size() {
		int size = 0;
		for (int num : mymap.values()){
		size+= num;
		}
	
		return size;
	}
	/**
	 * You will most likely return an instance of an inner class that you design
	 * to manage an <em>immutable</em> Iteration of keys over this bag.
	 * @return
	 */
	public Iterator iterator() {
		ArrayList<Object> myarr = new ArrayList<Object>();
		for (Object myObj: mymap.keySet() ){
			for(int count = 0 ; count < mymap.get(myObj); count++){
				myarr.add(myObj);
			}
		}
		return myarr.iterator();
	}
}