package student_classes;


import java.util.Arrays;
import java.util.RandomAccess;

/**
 * Your implementation goes here ...
 * @author Duke (xiang chen)
 *
 * @param <T>
 */
public class DynArray<T> implements RandomAccess {
	// your properties are defined here ...
	Object array[];
	private int size=0;
	private int capacity=8;
	private boolean allownull=true;
	private final int quant=32;
	/**
	 * Your documentation goes here.
	 * @param allowNulls .
	 */
	@SuppressWarnings("unchecked")
	public DynArray( boolean allowNulls ) {
		if(!allowNulls) this.allownull=allowNulls;
			array=(T[]) new Object[capacity];
	}
	/**
	 * Your documentation goes here.
	 */
	@SuppressWarnings("unchecked")
	public DynArray() {
		array=(T[])new Object[capacity];
		
	}
	/**
	 * Your documentation goes here.
	 * @param 
	 * @param 
	 */
	@SuppressWarnings("unchecked")
	public DynArray( int ensureCapacity, boolean allow_nulls ) {
	
		if( ensureCapacity<=0 ) {
			throw new IllegalArgumentException();
			
		}
		allownull=allow_nulls;
		capacity=Math.max(ensureCapacity, quant);
		array=(T[])new Object[this.capacity];
		
	}
	/**
	 * Your documentation goes here.
	 * @param 
	 */
	public void add( T ele ) {
	   if(ele==null&& !allownull) throw new NullPointerException();
		if(size==capacity) {
			capacity += quant;
			array = Arrays.copyOf(array, capacity);
		}
	   array[size]=ele;
	   size++;
	}
	/**
	 * Your documentation goes here.
	 * @param 
	 * @return
	 */
	public T remove( int atIndex ) {
		if(atIndex==0||size==0||size<=atIndex) {
			throw new ArrayIndexOutOfBoundsException(atIndex ); 
		}
		@SuppressWarnings("unchecked")
		T a = (T) array[atIndex];
		for(int i=atIndex;i<size-1;i++){
			array[i]=array[i+1];
		}
		size--;
		return a;
		
	}
	/**
	 * Your documentation goes here.
	 * @param 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public T get( int index ) {
		if(index<0||index>=size){
			throw new ArrayIndexOutOfBoundsException(index);
		}
		return (T)array[index];
	}
	/**
	 * Your documentation goes here.
	 * @param 
	 * @param object
	 */
	public void set( int index, T object ) {
		if(index<0||index>=size){
			throw new ArrayIndexOutOfBoundsException(index);
		}
		array[index]=object;
	}
	/**
	* Your documentation goes here.
	 * @return
	 */
	public int size() {
	    return size;
	}
	/**
	 * Your documentation goes here.
	 */
	public String toString() {
		return Arrays.toString(array);
	}
	/**
	 * Your documentation goes here.
	 */
	@SuppressWarnings("unchecked")
	public boolean equals( Object other ) {
		return Arrays.equals(array, (T[])other );
	}

}
