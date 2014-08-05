package student_classes;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
/**
 * <P>A heap is a complete binary tree that maintains the heap property, 
 * meaning that every <em>internal</em> node in the heap is greater
 * than or equal to either of its children. (In the case of a 
 * "min heap," then the condition is less than or equal ....)
 * </P>
 * 
 * <P>Unlike binary search
 * trees, which you've implemented, no explicit ordering is required
 * of the children; it's only the relationship between the children,
 * i.e., the left and right, to their respective roots (internal nodes)
 * that matters.</P>
 * <P>
 *  Now, we build heaps from the bottom up so as to ensure that the
 *  resulting tree is "complete," i.e., having no gaps. This is important
 *  because it allows us to traverse the nodes in left-right order and 
 *  place them into a flat one-dimensional array. Once we've done this,
 *  then \f$2i+1\f$, where \f$i\f$ is an in-range index gives the left
 *  child, and \f$2i+2\f$ gives the right. Oh, and \f$i/2-1\f$ gives the
 *  parent. (Recall that \f$i/2\f$ is integer division which is the floor
 *  of the quotient.)
 *  </P>
 *  <P>
 *  As a proof of concept, we include the classic heapsort by calling
 *  <code>sort</code> on the inner heap. You should convince yourself 
 *  that this algorithm is truly O(n log n).</P>
 *  
 * @author UMD CS Department.
 *
 * @param <T> a <code>Comparable</code> object.
 */
public class Heap<T extends Comparable<T>> { // generics included to jump start you
	private Comparable[] heap;
	private int size;
	/**
	 * Note: all of the work is done within this constructor. Given a
	 * Collection of Comparable objects, build a heap by calling
	 * the heapDown( index ) on successive indices down to 0.
	 * Recall that index = elements.length/2 - 1, which is the parent 
	 * node.
	 * @param elements a <code>Collection</code> of <code>Comparable</code> objects.
	 */
	public Heap( Collection<Comparable<T>> elements ) {
		int j=0;
		size=elements.size();
		heap=new Comparable[elements.size()];
		for(Comparable a:elements){
			heap[j++]=a;
		}
		//heap=(Comparable[]) elements.toArray();
		for(int i = size/2-1;i>=0;i--)
			heapDown(i,size-1);
		//System.arraycopy(elements, 0, heap, 1, elements.size());
	}
	
	
	/**
	 * It's a rare case when I publish details of private methods, but so much
	 * of the work of building and maintaining the heap is done by this 
	 * method that I thought you should know something about it.
	 * 
	 * 
	 * The basic idea is this method is called with an in-range index which
	 * it uses to compute the index of the left child, and an integer
	 * "end" that tells the algorithm where to stop ... "n" is the length of
	 * the original array when we're building the heap, and successively smaller
	 * values when we "sort" the array; in other words, as we move "n" to the
	 * left (by subtracting 1), we are only heapifying elements 0 through n.
	 * We need to do this or we would be "unsorting" what had been already
	 * sorted!
	 * 
	 * If the left child plus 1
	 * is also in range, then we have a right child that needs to also be considered
	 * in the heapification process. Essentially, we compare both the left and right
	 * or just the left (if the right is out of range) to the root and swap them if
	 * either is greater than the root. (The <code>swap</code> method does this.)
	 * Next, we set the index to the left child index (which could be the right
	 * child's index if the right child had been in range), compute a new left child
	 * index (2 * index (we just set) + 1) and repeat the process.
	 * 
	 * @param index <code>int</code>
	 * @param end <code>int</code>
	 */
	@SuppressWarnings("unchecked")
	private void heapDown( int index,int size) {
		int left = 2*index+1;
        int right = 2*index+2;
        int maxChild = 0;
        if(index > size|| left > size)
           return;
        if(right > size){
           if(heap[index].compareTo(heap[left]) < 0)
              swap(index, left);
        }
        else{
           maxChild = (heap[left].compareTo(heap[right]) > 0) ? left:right;
           if(heap[index].compareTo(heap[maxChild ]) < 0){
              swap(index, maxChild);
              heapDown(maxChild, size);
           }
        }
		
		/**int largerChild;
		Comparable temp=heap[index];
		while(index<size/2){
		int lchild=2*index+1;
		int rchild=2*index+2;
		if(rchild<size&&heap[lchild].compareTo(heap[rchild])<0)
			largerChild=rchild;
		largerChild=lchild;
		if(heap[index].compareTo(heap[largerChild])>=0)
			break;
		swap(index,largerChild);
		index=largerChild;
		
			}
		heap[index]=temp;**/
		}	
		
	
		//throw new UnsupportedOperationException("You must implement this method.");
	
	/**
	 * You should know what the procedure does: swaps contents of the 
	 * heap (array) by index.
	 * @param index
	 * @param leftChildIndex
	 */
	private void swap(int index, int leftChildIndex) {
		Comparable temp=heap[index];
		heap[index]=heap[leftChildIndex];
		heap[leftChildIndex]=temp;
		
		//throw new UnsupportedOperationException("You must implement this method.");
	}
	/**
	 * Arguably, the "main event." A heap sort is a selection
	 * sort, which we've gone over in class, except that the 
	 * heap is used to produce the next element in sort order.
	 */
	/**int a=size;
	public Comparable remove(){
		Comparable temp=heap[0];
		heap[0]=heap[--a];
		heapDown(0,a);
		return temp;
	}
	public void insertAt(int index, Comparable temp){
		heap[index]=temp;
	}**/
	public void sort() {
		int n=size-1;
		for(int i=n;i>0;i--){
            swap(0, i);
            n=n-1;
            heapDown(0,n);
        }	
	/**for(int j=size-1;j>=0;j--){
		Comparable biggest=remove();
		insertAt(j,biggest);
		**/
	}
		//throw new UnsupportedOperationException("You must implement this method.");
	
	
	/**
	 * This method is intended to be called by clients wishing to 
	 * pass arbitrary collections of Comparable objects into the
	 * Heap sort logic. Note: it took longer to figure out the
	 * generic constructions for this method's signature than to 
	 * write its actual logic, which is:
	 * <ol>
	 *  <li>Use the <code>lst</code> parameter to create a <code>Heap</code>,
	 *  that is, pass it directly to the constructor.</li>
	 *  <li>Invoke the <code>sort</code> method on the newly-created heap.</li>
	 *  <li>Use the <code>asList</code> method to return a <code>List</code>
	 *  of the appropriate objects.
	 *  </ol>
	 * @param lst
	 * @return
	 */
	public static <T extends Comparable<T> > List<T> sort( List<T> lst ) {
		Heap newHeap=new Heap(lst);
		newHeap.sort();
		return newHeap.asList();
		//throw new UnsupportedOperationException("You must implement this method.");
		
	}
	
	/**
	 * Returns the size of the heap ... perhaps someone wants to know 
	 * this.
	 * @return <code>int</code> greater than or equal to 0.
	 */
	public int size() {
		return size;
		//throw new UnsupportedOperationException("You must implement this method.");
	}
	/**
	 * Returns the contents of the heap as an object
	 * that implements List<T>, where T is a Comparable.
	 * @return
	 */
	public List<T> asList() { 
		ArrayList<T> aList=new ArrayList<T>();
		for(int i=0; i<size;i++){
			aList.add((T)heap[i]);
		}
		return aList;
		//throw new UnsupportedOperationException("You must implement this method.");
	}
	/**
	 * Public override ... sanity check, just prints array style.
	 */
	public String toString() {
		String str = "{ ";
		for( Comparable element : this.heap )
			str += element.toString() + ", ";
		return str + " }";
	}

}
