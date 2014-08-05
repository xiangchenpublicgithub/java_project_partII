package student_classes;
/**
 * The <code>EmptySet</code> represents the set containing no elements.
 * Observe that we have no method to <code>add</code> elements to a
 * <code>NonEmptySet</code>. One way of adding an element to a set is
 * to begin with the empty set, and from it construct a singleton set, 
 * which is a <code>NonEmptySet</code> containing that one element.
 * To that end, you will find the <code>add(T ele)</code> method on 
 * this class that simply creates a <code>NonEmptySet</code> that
 * contains this <code>ele</code>.
 * @author tomr
 *
 * @param <T>
 */
public class EmptySet<T> implements BasicSet<T> {
	/**
	 * The cardinalty of the empty set is 0, by definition.
	 * @return
	 */
	public int size() {
		return 0;
		//throw new UnsupportedOperationException("You need to implement this method." );
	}
	/** No set is the subset of the empty set, by definition.
	 * 
	 * @param element
	 * @return
	 */
	public boolean isMember(T element) {
		return false;
		//throw new UnsupportedOperationException("You need to implement this method." );
	}
	/** The empty set is the subset of any set, by definition.
	 * 
	 * @param other
	 * @return
	 */
	public boolean isSubset( BasicSet<T> other ) {
		return true;
		//throw new UnsupportedOperationException("You need to implement this method." );
	}
	/**
	 * The union of the empty set with any set, other, is
	 * the other set, by definition. (Think of the union
	 * of the empty set with any set as adding 0 to any
	 * integer ....)
	 * @param other
	 * @return
	 */
	public NonEmptySet<T> union( NonEmptySet<T> other ) {
		return other;
		//throw new UnsupportedOperationException("You need to implement this method." );
	}
	/**
	 * The intersection of any set and the empty set is the
	 * empty set, by definition. (Think of this as the
	 * product of any integer with 0 giving 0.)
	 * @param other
	 * @return
	 */
	public EmptySet<T> intersection( NonEmptySet<T> other) {
		return this;
		//throw new UnsupportedOperationException("You need to implement this method." );
	}
	/**
	 * The difference of the empty set an any Non empty set is
	 * the empty set, by definition.
	 * @param other
	 * @return
	 */
	public EmptySet<T> setDifference( NonEmptySet<T> other ) {
		return this;
		// TODO Auto-generated method stub
		//throw new UnsupportedOperationException("You need to implement this method." );
	}
	/**
	 * The only set that is a subset of the empty set is the empty set, and
	 * this gives us the definition of the equals method for this class.
	 */
	public boolean equals( Object other ) {
		if ( other == this) return true;
		if ( ! ( other instanceof EmptySet )) return false;
		@SuppressWarnings("unchecked")
		EmptySet<T> temp = ( EmptySet<T> ) other;
		return temp==this;
		
		//throw new UnsupportedOperationException("You need to implement this method." );
	}
	
	/**
	 * Prints the empty set as braces, {}.
	 */
	public String toString() {
		return "{}";
	}

}
