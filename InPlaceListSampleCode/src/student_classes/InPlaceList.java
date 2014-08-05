package student_classes;
/**
 * Demonstrates common programming idioms associated with the
 * creation, modification and examination of singly-linked
 * lists that are modified "in-situ," as opposed to referentially
 * transparent lists that express change through copies.
 * 
 * @author UMD CS Department
 *
 * @param <T>
 */
public class InPlaceList<T> {
	
	/* classic inner class */
	class Node {
		T	value;
		Node next=null;
		
		/* we will need these constructors */
		Node( T ele ) { this.value = ele; }
		Node( T ele, Node next ) {
			this( ele );
			this.next=next;
		}
	} //closes class Node.
	
	/* instance variables belonging to InPlaceList */
	private Node 	chain = null; // begin life MT and correct.
	private int		count = 0;	// and containing no nodes.
	
	/* define the only defaul ctor */
	public InPlaceList() { } // nothing need be done.
	
	/* public interface: adding, removing, searching, lists */
	public boolean isEmpty() { return this.chain == null; }
	public int size() { return this.count; }
	
	/**
	 * Pay attention to how elements are "added" to this list.
	 * In particular: note its signature. It is void, which 
	 * is your best clue that this linked list implementation
	 * is "opaque," i.e., works by side-effect. Modifications 
	 * are NOT made to copies, but to the underlying structure.
	 */
	public void add( T ele ) {
		this.chain = add_aux( ele, this.chain );
		this.count++;
	}
	
	private Node add_aux(T ele, Node head) {
		if( head == null ) 
			return new Node( ele );
		else 
			head.next = add_aux( ele, head.next );
		return head;
	}
	
	public void remove( T ele ) {
		this.chain=remove_aux( ele, this.chain );
	}

	private Node remove_aux(T ele, Node head) {
		if( head == null ) 
			return null;
		else if( head.value.equals( ele ) ) {
			this.count--;
			head = remove_aux( ele, head.next );
		}
		else 
			head.next = remove_aux( ele, head.next );
		
		return head;
	}
	/**
	 * A colorful example of reversing a list in situ,
	 * in other words, on top of itself.
	 */
	public void reverse() {
		this.chain = reverse_aux( this.chain, null );
	}

	private Node reverse_aux(Node head, Node mirrored_nodes ) {
		if( head == null ) return mirrored_nodes;
		else return reverse_aux( head.next, new Node( head.value, mirrored_nodes ));
	}

	/* overrides */
	/**
	 * Do not fail to implement something for this function,
	 * otherwise, you'll be perpetually lost ...
	 */
	public String toString() {
		String str = "[";
		Node head = this.chain;
		while( head != null ) {
			str += head.value.toString() + ", ";
			head = head.next;
		}
		return str + "]"; // note, allows trailing ","'s 
	}

}
