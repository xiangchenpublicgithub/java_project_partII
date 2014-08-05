package listClasses;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

import listClasses.BasicLinkedList.Node;
/*This generic singly-linked list relies on a head (reference to first element of the list) and tail (reference to the last element
of the list). Both are set to null when the list is empty. Both point to the same element when there is only one element
in the list.



A node structure has only two fields: data and next reference. The class must only define the following entities: a class
Node, head and tail references and an integer representing the list size. All the entities are defined as protected so
they can be accessed by the subclass.
 */
public class BasicLinkedList<T > implements Iterable<T>{

	@SuppressWarnings("hiding")
	public class Node<T> {

		protected T data;
		protected Node<T> next;

		public Node(T num) {
			this.data = num;
			this.next = null;
		}
	}


	protected Node <T>head;
	protected int listSize;
	/*Defines an empty linked list. No nodes are created. We do not use dummy nodes for this list 
	 */

	public BasicLinkedList (){
		head = null;

		listSize = 0;
	}

	/*Adds element to the end of the list. 
	Do not use iterators to implement this method.
	 */
	public BasicLinkedList<T> addToEnd ( T data ){
		Node <T>myNode = new Node<T>(data);
		//add to the empty list
		if(head == null){
			head = myNode;
			listSize ++;
		}else{

			
			Node<T>tail=head;
			
              while(tail.next!=null){
				
            	 tail=tail.next;
				

			}
			
              tail.next=myNode;
			listSize ++;
		}
		return this;
	}

	/*Adds element to the front of the list.
	 *  Do not use iterators to implement this method.
	 */
	public BasicLinkedList<T> addToFront ( T data ){
		
		Node <T>myNode = new Node<T>(data);
		//add to the empty list
		if(head == null){
			head = myNode;
			listSize ++;
		}else{
			Node<T> tail = head;
			head = myNode;
			head.next = tail;
			while( tail.next != null){
				tail = tail.next;
			}
		
			
			listSize ++;


		}
		return this;
	}
	
	/*Returns but does not remove the first element from the list. If there are no elements the method returns null. Do not
implement this method using iterators.
	 */
	public T getFirst (){
		//T first = null;
		if(head != null){
			//first = head.data;
			return head.data;
		}
		//return first;
		return null;
	}
	
	/*Returns but does not remove the last element from the list. If there are no elements the method returns null. Do not
	implement this method using iterators.
		 */
	public T getLast (){
		//Node<T> curr = head;
		//T last = null;
		//while(curr != null){
			//last = curr.data;
			//curr = curr.next;

		//}
		//return last;
		if( head != null){
		Node<T> tail=head;
		while(tail.next != null){
			tail = tail.next;
		}
		return  tail.data;
		}
		return null;
		

	}

	/*return size, Notice you must not traverse the list to compute the size. This method just returns the value of the instance variable you
use to keep track of size.
	 */
	public int getSize (){
		return listSize;	
	}




	//iterate the list
	@Override
	public Iterator<T> iterator() {
		class MyIterator implements Iterator<T>{
			Node <T>cur = head;
			T data = null;
			//check if it has next
			@Override
			public boolean hasNext() {
				return(cur!=null);
			}
			
			//return next in the list
			@Override
			public T next() {
				if(hasNext()){
					data = cur.data;
					cur = cur.next;
				}
				return data;
			}




			@Override
			public void remove()  {
				throw new UnsupportedOperationException();
			}
		}
		return new MyIterator();	

	}
	/*Removes ALL instances of targetData from the list. Notice that you must remove the elements by performing a
	single traversal over the list. You may not use any of the other retrieval methods associated with the class in order to
	complete the removal process. You must use the provided comparator (do not use equals) to find those elements that
	match the target. Do not implement implement this method using iterators.
	 */
	public BasicLinkedList<T> remove ( T targetData, Comparator< T > comparator ){
		/**Node <T>curr = head;  
		//Node <T>prev = curr;  

		//while(curr != null){  
			//if(comparator.compare(targetData, curr.data) == 0){  
				//if (curr.equals(head)) {
					head = head.next;
					listSize--;
				}else{

					prev.next = curr.next;
					listSize--;
				}
			}  else
				prev = curr;
			    curr = curr.next;

		}  
		return this;**/
		if ( comparator.compare(targetData, head.data) == 0){
			Node <T> tail = head;
			head = tail.next;
			while ( tail.next != null){
				tail = tail.next;
				
			}
			listSize--;
			return this;
		}else {
			
			Node <T> tail = head;
			while ( tail.next != null){
				if ( comparator.compare(targetData, tail.next.data) == 0){
					if ( tail.next.next == null){
						tail.next=null;
						listSize--;
					    break;
					}
					tail.next = tail.next.next;
					
					listSize--;
				}
				tail = tail.next;
			}
		} return this;
	}
	/*Removes and returns the first element from the list. If there are no elements the method returns null. Do not
implement this method using iterators.
	 */
	public T retrieveFirstElement(){
		T first = null;
		if(head != null) first= head.data;
		if(head != null && head.next != null){

			head = head.next;
			listSize--;
			
		}if(head == null){

			head = null;
		}
		return first;

	}
	/*Removes and returns the last element from the list. If there are no elements the method returns null. Do not
implement this method using iterators.																		
	 */
	public T  retrieveLastElement ( ){
		T last = null;
		Node<T> curr = head;
		Node<T> pre = null;
		boolean done = false;
		if(head == null){
			head = null;
			done = true;
		}else if(head.next == null){
			head = null;
			done = true;
		}
		while(curr!=null && !done){
			if(curr.next == null){
				last = curr.data;
				curr = null;
				pre.next = null;
			}else{
				pre = curr;
				curr = curr.next;
			}
		
	}

	return  last;


}



public static void main(String[] args) {
	BasicLinkedList<String> basicList = new BasicLinkedList<String>();

	basicList.addToEnd("Red").addToFront("Yellow").addToFront("Blue");
	System.out.println("First: " + basicList.getFirst());
	System.out.println("Last: " + basicList.getLast());
	System.out.println("Size: " + basicList.getSize());
	System.out.println("Retrieve First: " + basicList.retrieveFirstElement());
	System.out.println("Retrieve Last: " + basicList.retrieveLastElement());
	System.out.println("Removing Red");
	basicList.remove("Red", String.CASE_INSENSITIVE_ORDER);
	System.out.print("Iteration: ");
	for (String entry : basicList) {
		System.out.print(entry + " ");
	}

	SortedLinkedList<String> sortedList = new SortedLinkedList<String>(String.CASE_INSENSITIVE_ORDER);
	sortedList.add("Blue").add("Red").add("Yellow").add("White");
	System.out.print("\n\nIteration (for sorted list): ");
	for (String entry : sortedList) {
		System.out.print(entry + " ");
	}
	sortedList.remove("Red");
	System.out.print("\nAfter remove in sorted list first is: ");
	System.out.println(sortedList.getFirst());
	System.out.println(sortedList.getSize());
}




}
