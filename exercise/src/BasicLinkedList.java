package listClasses;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;


public class BasicLinkedList<T> {
	
	protected Node head;
	protected int listSize;
	
	protected class Node {
		T data;
		Node next;
		
		protected Node() {
			data = null;
			next = null;
		}
		
		protected Node(T data) {
			this.data = data;
			next = null;
		}
		
		protected Node(T data, Node next) {
			this.data = data;
			this.next = next;
		}
	}
	
	public BasicLinkedList() {
		head = null;
		listSize = 0;
	}
	
	public BasicLinkedList<T> addToEnd(T data) {
//	public void addToEnd(T data) {
		BasicLinkedList<T> bll = new BasicLinkedList<T>();	
		
		Node endNode = new Node(data);

		if (head == null) {
			head = endNode;
			listSize = 1;
		}
		else {
			Node temp = head;
			while (temp.next != null) 
				temp = temp.next;
			
			temp.next = endNode;						
			listSize = listSize + 1;
		}
		
		bll.head = head;			
		bll.listSize = listSize;
		return bll;				
	}
	
	public BasicLinkedList<T> addToFront(T data) {
//	public void addToFront(T data) {
		BasicLinkedList<T> bll = new BasicLinkedList<T>();		
//		Node temp = new Node(data);
		
/*		bll.head = temp;
		bll.head.next = head;
		bll.listSize = listSize + 1;

		head = bll.head;
		listSize = bll.listSize;
*/
		this.head = new Node(data, head);
		this.listSize ++;
		
		bll.head = head;
		bll.listSize = listSize;
		return bll;
	}
	
	public T getFirst() {
		Node temp = head;
		
		if (temp != null) {
			return temp.data;
		}
		else
			return null;
	}
	
	public T getLast() {
		Node temp = head;
		if (temp == null) return null;
		
		while (temp.next != null)	temp = temp.next;			
		
		return temp.data;
	}
	
	public int getSize() {
		return listSize;
	}
	
	/**************************
	 * implements iterator
	 * @return
	 */
	public Iterator<T> iterator() {	 
		return new LinkedListIterator();
	}

	private class LinkedListIterator implements Iterator<T> {
	   
	    private Node nextNode;

	    public LinkedListIterator() {	      
	    	nextNode = head;
	    }

	    public boolean hasNext() {
	        return nextNode != null;
	    }

	    public T next() {
	        if (!hasNext()) 
	        	throw new NoSuchElementException();
	        T res = nextNode.data;
	        nextNode = nextNode.next;
	        return res;
	    }

	    public void remove() { 
	    	throw new UnsupportedOperationException(); 
	    }	    
	}
		
	public BasicLinkedList<T> remove(T targetData, Comparator<T> comparator) {
		BasicLinkedList<T> bll = new BasicLinkedList<T>();	

		if (head == null)
			return null;
		else {
			while (comparator.compare(head.data,targetData)==0) {
				head = head.next;
				listSize --;
			}
			
			Node current = head;
			Node previous = null;
			while (current != null) {
				if (comparator.compare(current.data,targetData)==0){
					previous.next = current.next;
					current = current.next;
					listSize --;
				}
				else {
					previous = current;
					current = current.next;
				}
			}
			
			bll.head = head;
			bll.listSize = listSize;
			return bll;
		}
	}
	
	public T retrieveFirstElement() {
		if (head == null)
			return null;
		
		T data = this.getFirst();
		head = head.next;
		listSize --;
		return data;
	}
	
	public T retrieveLastElement() {
		if (head == null)
			return null;
		
		T data = this.getLast();
		Node current = head;
		Node previous = null;
		while (current.next != null) { 
			previous = current;
			current = current.next;
		}
		previous.next = null;
		listSize --;
		return data;
	}
	
}

