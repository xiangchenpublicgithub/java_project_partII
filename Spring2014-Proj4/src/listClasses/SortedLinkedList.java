package listClasses;

import java.util.Comparator;

import listClasses.BasicLinkedList;

/*Implements a generic sorted list using a provided Comparator. It extends BasicLinkedList class.
 */

public class SortedLinkedList< T > extends BasicLinkedList<T>{

	/*Creates an empty list that is associated with the specified comparator. It must call the super class constructor to initialize
	the appropriate variables.
	 */
	Comparator<T> comparator;



	public SortedLinkedList ( Comparator< T > comparator ){
		this.comparator=comparator;
		super.head=null;
		super.listSize=0;
	}
	/*Inserts the specified element at the correct position in the sorted list. Notice we can insert the same element several
times. Your implementation must traverse the list only once in order to perform the insertion. Do not implement this
method using iterators. Notice that you do not need to call any of the super class methods in order to implement this
method.
	 */
	public SortedLinkedList< T > add (T element){
		Node<T> myNode= new Node<T>(element);
		// check for empty list
		if (head == null) {
			head = myNode;
			listSize++;
		}else {
			Node <T>curr = head;
			Node <T>prev=null;
			boolean done=false;
			while (curr !=null&&!done){
				if(comparator.compare(curr.data, element)<=0){

					prev = curr;
					curr = curr.next;



				}else{
					if(prev==null){
						head=myNode;
					
						myNode.next=curr;
						listSize++;

					}else{
						prev.next=myNode;
						myNode.next=curr;
						listSize++;
					}
					done=true;

				}

			}
			if(!done){
			prev.next=myNode;
			listSize++;
			}

		}
		return this;


	}





	/*Implements the remove operation by calling the super class remove method.

	 */
	public BasicLinkedList<T> remove (T targetData){
		super.remove(targetData, comparator);
		return this;
	}

	/*This operation is invalid for a sorted list. An UnsupportedOperationException will be generated using the message
	"Invalid operation for sorted list."
	 */
	public BasicLinkedList <T> addToEnd (T data){
		throw new UnsupportedOperationException (" will be generated using the message Invalid operation for sorted list.");
	}

	/*This operation is invalid for a sorted list. An UnsupportedOperationException will be generated using the message
	"Invalid operation for sorted list."
	 */
	public BasicLinkedList <T> addToFront (T data){
		throw new UnsupportedOperationException (" will be generated using the message Invalid operation for sorted list.");

	}
}