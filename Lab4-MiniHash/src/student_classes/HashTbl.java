package student_classes;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/**
 * This is a truly minimal implementation of the well-known HashTable 
 * class that is still defined in Java (qv). Essentially, a HashTable
 * allows users to associate values with keys in O(1) time (amortized
 * over the life of the running application). 
 * 
 * Note: this implementation throws NullPointerExceptions if <code>put</code>
 * is called with either a null key or a null value.
 * 
 * Moreover, instead of returning Enumerations (old school), this version
 * returns Iterators for its keys and values. 
 * 
 * A note on Iterators: The iterators that we are using here are <em>not</em>
 * true <code>Iterator</code>s in the following sense: they are not 
 * <em>thread-safe</em>. Unlike Java's standard <code>Iterator</code> implementations,
 * our iterators are just copies of the current state that are created as needed
 * and given to the client. Real iterators, on the other hand, are more directly
 * connected with the underlying collection, meaning that a real iterator needs
 * to <code>throw</code> a <code>ConcurrentModificationException</code>.
 * In the literature, objects that are sensitive to changes made outside of
 * their purview are called <em>fail-fast</em>. Naturally, removing an entry
 * through the Iterator's <code>remove</code> method is acceptable, but any other
 * modification should raise the concurrent modification exception---more about
 * this in class.
 * 
 * You could theoretically use objects of this class as a hash table, but
 * too much would still need to be done, for real applications. Curious
 * students should see the documentation for the <code>HashTable</code> class in
 * the online API (from Oracle).
 * 
 * @author UMD CS Department.
 *
 * @param <E> ///> Keys type
 * @param <V> ///> Values type.
 */
public class HashTbl<E, V> {
	
	class Entry {
		private E key;
		private V value;
		
		Entry( E entryKey, V entryValue ) {
			this.key=entryKey;
			this.value=entryValue;
		}
	} // closes class Entry.
	private final int defaultSize=64;
	private Object buckets[] = new Object[ defaultSize ];
	/** Only one public constructor is provided ... in reality, we'd
	 * probably like a few more that allowed us to control growth rate,
	 * initial size, etc.
	 */
	public HashTbl() { 
		for( int index=0; index < this.buckets.length; index++ )
			this.buckets[ index ] = new LinkedList<Entry>();
	}
	/**
	 * Installs the <code>value</code> on the <code>key</code> in this
	 * table. Note, if either parameter is <code>null</code> a
	 * <code>NullPointerException</code> is signaled. 
	 * @param key
	 * @param value
	 */

	

	public void put( E key, V value ) {
		if( key==null || value==null )
			throw new NullPointerException();
		int hashCode = key.hashCode();
		List<Entry> bucket = (List<Entry>) this.buckets[ Math.abs( hashCode % this.buckets.length )];
		addOrReplace( key, value, bucket );
	}
	
	private void addOrReplace(E key, V value, List<Entry> bucket) {
		for( Entry entry : bucket ) {
			if( entry.key.equals( key ) ) {
				entry.value = value;
				return;
			}
		}
		bucket.add( new Entry( key, value ) );
	}
	/**
	 * Returns the value assocated with <code>key</code>. Because this is a table,
	 * nulls are not allowed, therefore if a <code>null</code> is returned ... we
	 * know that the key wasn't found.
	 * @param key
	 * @return
	 */
	public V get( E key ) {
		int hashCode = key.hashCode();
		List<Entry> bucket = (List<Entry>)this.buckets[ Math.abs( hashCode % this.buckets.length )];
		for( Entry entry : bucket ) 
			if( entry.key.equals( key ) )
				return (V) entry.value;
		return null;
	}
	/**
	 * Returns an Iterator over the <code>key</code>s in this table; note, no particular
	 * order is specified here.
	 * @return an Iterator over Keys.
	 */
	public Iterator<E> keys() {
		List<E> keySet = new LinkedList();
		for( int index=0; index < this.buckets.length; index++ ) {
			if( this.buckets[ index ]!= null ) {
				List<Entry> entries = (List<Entry>) this.buckets[index];
				for( Entry anEntry : entries )
					keySet.add( anEntry.key );
			}
		}
		return keySet.iterator();
	}
	/**
	 * Returns an Iterator over the <code>value</code>s in the table; note, no
	 * particular order is assumed.
	 * @return
	 */
	public Iterator<V> values() {
		List<V> valuesSet = new LinkedList();
		for( int index=0; index < this.buckets.length; index++ )
			if( this.buckets[ index ] != null ) {
				List<Entry> entries = (List<Entry>)this.buckets[ index ];
				for( Entry anEntry : entries )
					valuesSet.add( anEntry.value );
			}
		return valuesSet.iterator();
	}

}
