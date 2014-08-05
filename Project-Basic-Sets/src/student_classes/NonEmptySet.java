package student_classes;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


/**
 * NonEmptysets are actually finite, non-empty sets---to be precise. These
 * are distinguished from EmptySets (qv) in that a NonEmptySet contains 
 * at least one element. This means, among other things, that methods such
 * as size(), isMember(), isSubset(), etc., have more "interesting" behaviors
 * than they might for Empty Sets.
 * 
 * @author UMD CS Department
 *
 * @param <T>
 */
public class NonEmptySet<T>  implements BasicSet<T> {
	
	private List<T> elements=new LinkedList<T>(); // you may replace this with any
											// other class that you prefer.
	
	/**
	 * A convenience CTor, given an arbitrary collection (whose
	 * elements may contain duplicate entries), create a NonEmptySet.
	 * This constructor is used by the various Tests, but is NOT tested
	 * itself. You may choose to use it for your own tests!
	 * @param names2
	 */
	public NonEmptySet( Collection<T> names2 ) {
		Iterator<T> iter = names2.iterator();
		while( iter.hasNext() ) {
			T element = iter.next();
			if( ! this.elements.contains(element))
				this.elements.add( element );
		}
	}
	/**
	 * Essentially creates a Shallow copy of a NonEmpty set.
	 * @param set
	 */
	
	public NonEmptySet( NonEmptySet<T> set ) {
		//List<T> aList=new LinkedList<T>();
		//NonEmptySet<T> temp=new NonEmptySet<T>(aList) ;
		for ( T a: set.elements){
			this.elements.add(a);
		}
		
		//this.elements=set.elements.copyElements()
		
		
		
		//throw new UnsupportedOperationException("You need to implement this method." );
	}
	// only used by copy ctor ...
	private List<T> copyElements() {
		List<T> temp= new LinkedList<T>();
		for ( T a: this.elements){
			temp.add(a);
		}
		return temp;
		
		//throw new UnsupportedOperationException("You need to implement this method." );
	}
	/**
	 * Called only by internal routines, such as union, etc., in order
	 * to create a NonEmptySet from a raw List.
	 * @param elements
	 */
	protected NonEmptySet( List<T> elements ) {
		this.elements=elements;
	}
	/**
	 * Returns the cardinality of this non-empty set, which
	 * should be an integer >= 1.
	 * @return
	 */
	public int size() {
		return this.elements.size();
		//throw new UnsupportedOperationException("You need to implement this method." );	}
	}
	/**
	 * Returns <code>true</code> only when the <code>element</code>
	 * appears in <code>this</code> NonEmptySet.
	 */
	public boolean isMember(T element) {
		for ( T a : this.elements){
			if ( a == element)
				return true;
		}
		return false;
		//throw new UnsupportedOperationException("You need to implement this method." );
	}
	/**
	 * Returns true iff every element of <em>this</em> NonEmptySet
	 * is found on <code>set2</code>. Note, if <code>set2</code> is an 
	 * <code>EmptySet</code>, then this method returns <code>false</code> because
	 * no set is a subset of the empty set (except, of course,
	 * the empty set).
	 * 
	 * <P>
	 * For example:
	 * S = {1,2,3}, T = {1,2,3,4,5}, then S.isSubset( T ) => true,
	 * but T.isSubset( S ) => false.
	 */
	public boolean isSubset(NonEmptySet<T> set2) {
		if (this.size() > set2.size()) return false;
		
		for ( T a: this.elements){
			int i = 0;
			for ( T b:set2.elements){
				if (a.equals(b))
					//return false;
					i++;
			}
			if (i == 0) return false;
		}
		return true;
		//throw new UnsupportedOperationException("You need to implement this method." );
	}
	/**
	 * No set is the subset of the Empty Set (other than the 
	 * Empty set). That is, S = {1,2,3} and T={}, then
	 * S.isSubset( T ) => false, but also note that
	 * T.isSubset( S ) => true (always).
	 * @param set2
	 * @return
	 */
	public boolean isSubset( EmptySet<T> set2 ) {
		return false;
		//throw new UnsupportedOperationException("You need to implement this method." );
	}
	/**
	 * Returns a <em>new NonEmptySet</em> whose elements
	 * are the union of the elements of <code>other</code>.
	 * Note, if <code>other</code> is an Empty set, then 
	 * the union of any set with the empty set is the original
	 * set ... more formally,
	 * \f[
	 * A \cup B = \{ e \lvert \; e\in A \text{ or } e\in B \}.
	 * \f]
	 */
	public NonEmptySet<T> union( NonEmptySet<T> other ) {
		NonEmptySet<T>  temp = new NonEmptySet<T> (this);
		
			for ( T b:other.elements){
				this.elements.add(b);
			}
			
		
		for ( T a:temp.elements){
			for ( T b:other.elements){
				if ( a.equals(b))
				this.elements.remove(b);
			}
			
		}
		return this;
		//throw new UnsupportedOperationException("You need to implement this method." );
	}
	/**
	 * The union of any non empty set @ with the empty set is 
	 * a copy of the original set S.
	 * @param other
	 * @return
	 */
	public NonEmptySet<T> union( EmptySet<T> other ) {
		return this;
		//throw new UnsupportedOperationException("You need to implement this method." );
	}
	/**
	 * The intersection of two sets is a new set containing all of
	 * the elements contained in both. Note, if the sets in question
	 * are disjoint, their intersection is empty ... note the return
	 * type of this method.
	 * <P> More formally,
	 * \f[
	 * A \cap B = \{ e \lvert\; e\in A \text{ and } e \in B \}.
	 * \f]
	 * @param other
	 * @return
	 */
	public BasicSet<T> intersection( NonEmptySet<T> other ) {
		List<T> temp2=new LinkedList<T>();
		NonEmptySet<T>  temp1 = new NonEmptySet<T> (temp2);
		//NonEmptySet<T>  temp = new NonEmptySet<T> (this);
		for ( T a:this.elements){
			for ( T b:other.elements){
				if ( a.equals(b)){
					//this.elements.remove(b);
					temp1.elements.add(a);
				}
			}
		}
		return temp1;
		//throw new UnsupportedOperationException("You need to implement this method." );
	}
	/**
	 * The intersection of any set S with the Empty set is
	 * the empty set.
	 * @param other
	 * @return
	 */
	public EmptySet<T> intersection( EmptySet<T> other ) {
		return  other;
		//throw new UnsupportedOperationException("You need to implement this method." );
	}
	/**
	 * The set difference between two sets S and T consists
	 * of a new set of elements that appear in S but NOT
	 * in T. Formally:
	 * \f[
	 * A-B = \{ e \lvert\; e\in A \text{ and } e \not\in B\}.
	 * \f]
	 * Observe the return type of this method, and understand
	 * its implication(s).
	 * @param other
	 * @return
	 */
	public BasicSet<T> setDifference(NonEmptySet<T> other) {
		//BasicSet<T> temp1 = (BasicSet<T>) other;
		NonEmptySet<T>  temp = new NonEmptySet<T> (this);
		
		for ( T a:temp.elements){
			for ( T b:other.elements){
				if ( a.equals(b)){
					this.elements.remove(a);
				}
			}
			//BasicSet<T>  temp1 = new NonEmptySet<T> (this);
			//return temp1;
			//return this;
		}
		return this;
		//throw new UnsupportedOperationException("You need to implement this method." );
	}
	/**
	 * The result of the set difference of S and T, where T is empty, is
	 * a copy of S.
	 * @param other
	 * @return
	 */
	public NonEmptySet<T> setDifference( EmptySet<T> other ) {
		NonEmptySet<T> temp= new NonEmptySet<T> (this);
		return temp;
		//throw new UnsupportedOperationException("You need to implement this method." );
	}
	/**
	 * Standard override that prints the elements of a Set in curely brace
	 * notation.
	 */
	public String toString() {
		return "{"+this.elements.toString()+"}";
		//throw new UnsupportedOperationException("You need to implement this method." );
	}
	/**
	 * Two sets, S and T, are equal iff S is a subset of T and
	 * T is a subset of S.
	 */
	public boolean equals( Object other ) {
		if ( other == this) return true;
		if ( ! ( other instanceof NonEmptySet )) return false;
		if ( other instanceof EmptySet) return false;
		@SuppressWarnings("unchecked")
		NonEmptySet<T> temp = ( NonEmptySet<T> ) other;
		return this.isSubset(temp)&&temp.isSubset(this);
		
		//throw new UnsupportedOperationException("You need to implement this method." );
	}
}
