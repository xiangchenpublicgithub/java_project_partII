package student_classes;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.ConcurrentSkipListSet;

/**
 * A Binary Search Tree data-structure that maintains a count
 * of repetitive values (as nodes).
 * 
 * @author UMD CS Dept.
 *
 * @param <T>
 */
public class DenseSearchTree< T extends Comparable<T> > 
implements Iterable<T> {

	class TreeNode{
		T key;
		int count;
		TreeNode left, right ;
		TreeNode(T key){

			this.key = key;
			count = 1;

		}

	}

	TreeNode root;
	int size = 0;


	// declare properties, inner classes, etc.

	public DenseSearchTree() { }
	/**
	 * Note: our trees follow a slightly different convention regarding 
	 * both our ordering relation and the placement of duplicates, viz:
	 * 
	 * Left branch contains all elements < tree.value;
	 * Right branch contains all elements >= tree.value.
	 * 
	 * Rather than place duplicate elements on the right branch,
	 * each Tree Node maintains a count of copies. For example, 
	 * if we had a tree of Integers containing two instances of the
	 * number 1, our Tree Node would logically appear as 
	 * [ left-branch 1:2 right-branch ], where
	 * 1:2 means 2 copies of the integer 1.
	 * 
	 * Thus, your add logic will either make a new node and insert
	 * it in the correct position in the tree, or it will find a
	 * node with the value (key) equal to the value you are adding,
	 * and increment its count.
	 * 
	 * This simplifies your remove logic: if the node's count
	 * is > 0, then decrement by 1, otherwise invoke the remove
	 * logic to physically remove the node and replace it with a 
	 * Binary Search Tree.
	 * 
	 * Finally, the "price you pay" for this simplification is that
	 * your Iterator (which presents an "in-order" view of the tree),
	 * needs to "inflate" or "expand" each node. That is, if you have
	 * a node 
	 * [ left 3:4 right ]
	 * then 4 instances of the integer 3 need to be created and 
	 * put into the iteration.
	 * 
	 * @param element
	 */
	public void add( T element ) {

		boolean done = false;
		if(root == null) {
			root = new TreeNode(element);
			size++;

		}else{

			TreeNode  curr, prev; 
			curr = root;
			prev = curr;

			while (curr !=null &&!done){
				if(curr.key.compareTo(element)==0){
					curr.count++;
					done = true;
					size ++;
				}
				else if(curr.key.compareTo(element)>0){
					if (curr.left == null){
						curr.left = new TreeNode(element);
						done = true;
						size++;
					}

					prev = curr;
					curr = curr.left;


				}else {
					if(curr.right == null){
						curr.right = new TreeNode(element);
						done = true;
						size++;

					}
					prev = curr;
					curr = curr.right;
				}

			}
			if(!done){
				if(prev.key.compareTo(element)>0){
					prev.left = new TreeNode(element); 
				}if(prev.key.compareTo(element)<0){
					prev.right = new TreeNode(element); 
				} size++;
			}

		}
	}

	/**
	 * Returns true if at least instance of <code>target</code>
	 * is found in tree.
	 * 
	 * @param target
	 * @return
	 */
	public boolean contains( T target ) {
		boolean find = false;
		if (root.key.compareTo(target) == 0) find = true;
		else {
			TreeNode curr = root;
			while(curr!= null&&! find){
				if (curr.key.compareTo(target) > 0){

					curr = curr.left;

				}else if (curr.key.compareTo(target) < 0){

					curr = curr.right;
				}else if (curr.key.compareTo(target) == 0){
					find = true;
				}
			}
		}
		return find;
	}

	/**
	 * Returns an int >= 0, indicating how many occurrences
	 * of <code>target</code> reside in the tree. Note, this
	 * function returns 0 when the item is NOT found in tree.
	 * 
	 * @param target
	 * @param tree
	 * @return
	 */
	public int count( T target ) {
		int count = 0;
		if (root.key.compareTo(target) == 0) count = root.count;
		else {
			TreeNode curr = root;
			boolean done = false;
			while(curr!= null && !done){
				if (curr.key.compareTo(target) > 0){

					curr = curr.left;

				}else if (curr.key.compareTo(target) < 0){

					curr = curr.right;
				} else{
					count = curr.count;
					done = true;

				}
			}
		}
		return count;
	}

	/**
	 * Returns "inflated" size of tree, meaning a count of
	 * all keys in the tree
	 * @return
	 */
	public int size() {
		return size;

	}
	/**
	 * Returns the set representation of this Tree. In this case,
	 * the set will contain unique elements (i.e., it should omit
	 * multiple instances) that comprise the tree. Depending upon
	 * your internal representation, this may be challenging. If 
	 * you are having trouble, examine the Java online API; look
	 * under Collections. Study the concrete classes that implement
	 * the Set interface ... consider ConcurrentSkipLists ....
	 * @return
	 */
	public Set<T> asSet() {
		ConcurrentSkipListSet <T> mySet = new ConcurrentSkipListSet<T>();
		TreeNode curr = root;
		while (curr!= null){
			mySet.add(curr.key);
			curr = curr.right;

		}
		TreeNode curr1 = root;
		while (curr1!= null){
			mySet.add(curr1.key);
			curr1 = curr1.left;

		}

		return mySet;

	}

	/**
	 * Somewhat streamlined or simplified version of the classic
	 * BST remove algorithm. Because we're maintaining counts of 
	 * keys on each node, many times this method find the node
	 * whose value (key) equals the <code>target</code> and decrements
	 * the counter by 1. If that would result in the counter going to 
	 * 0, however, then the remove logic finds the greatest in order
	 * successor and replaces the node to be removed with that, and 
	 * then continues to remove the in order successor whose value
	 * was used to re-label the node to be removed.
	 * 
	 * @param target
	 */
	public void remove( T target ) {
		if (root!= null && this.contains(target)){
			TreeNode curr= root;
			boolean done = false;
			while (curr != null&&!done) {
				if (curr.key.compareTo(target) == 0 ) {
					if (curr.count > 1){
						curr.count --;
						done = true;
					}else{
						remove (target, root);
						done = true;
					}
				}else{
					if (curr.key.compareTo(target) > 0) {

						curr = curr.left;
					} else {

						curr = curr.right;
					}
				}
			}
			size--;
		}


	}



	public void remove(T key,TreeNode root){
		//	TreeNode parent = root;
		//	TreeNode curr = parent;
		//	boolean done = false;
		//	if (curr.key.compareTo(key) == 0 && ! done) {
		//
		//
		//		TreeNode replacement ;
		//		if (curr.left!=null) {
		//
		//			replacement = getReplacement(curr);
		//			curr.key = replacement.key;
		//			curr.count = replacement.count;
		//			curr.left = remove(replacement.key,curr.left);
		//
		//			done = true;
		//
		//
		//
		//		} else if (curr.right!=null){
		//			replacement = getReplacementrightmin (curr);
		//			curr.key = replacement.key;
		//			curr.count = replacement.count;
	
		if (root!= null && this.contains(key)){
		if(key.compareTo(root.key)<0){
			remove (key, root.left);
		}else if (key.compareTo(root.key)>0){
			remove (key, root.right);
		}else{
			if (root.left!= null){
				TreeNode replace = getReplacement(root);
				root.key = replace.key;
				root.count = replace.count;
				remove (replace.key, root.left);
			}else if (root.right != null){
				TreeNode replace = getReplacementrightmin(root);
				root.key = replace.key;
				root.count = replace.count;
				remove (replace.key, root.right);
			}else{
				root = null;
			}
		}
		}

		}




		public TreeNode getReplacement(TreeNode start) {
			TreeNode curr = start.left;
			TreeNode replacement = null;
			while (curr != null) {
				replacement = curr;
				curr = curr.right;			
			}

			return replacement;
		}
		public TreeNode getReplacementrightmin(TreeNode start) {
			TreeNode curr = start.right;
			TreeNode replacement = null;
			while (curr != null) {
				replacement = curr;
				curr = curr.left;			
			}

			return replacement;
		}

		/**
		 * Returns a value of type T or throws an <code>IllegalStateException</code>
		 * if this function is called on an empty tree.
		 * 
		 * @return
		 */
		public T getMin() {
			if (this == null) throw new IllegalStateException();
			TreeNode min = root;
			while (min.left!=null){
				min = min.left;
			}
			return min.key;
		}


		/**
		 * Returns the max value (of type T) or throws an 
		 * <code>IllegalStateException</code> if this function
		 * is called on an empty tree.
		 * 
		 * @return
		 */
		public T getMax() {
			if (this == null) throw new IllegalStateException();
			TreeNode max = root;
			while (max.right!=null){
				max = max.right;
			}
			return max.key;
		}


		public String toString() {
			throw new UnsupportedOperationException("you must implement this method");
		}
		/**
		 * Returns an iterator over the DenseSearchTree. Note, this iterator should
		 * present an "in order" view of the keys in the tree.
		 */

		public ArrayList<T> inordertraversal (TreeNode root, ArrayList<T> order){
			if(root!= null){
				inordertraversal(root.left, order);
				for (int count = 0; count < count(root.key); count++){
					order.add(root.key);
				}
				inordertraversal(root.right, order);
			}
			return order;
		}
		@Override
		public Iterator<T> iterator() {
			ArrayList<T> myiter = new ArrayList<T>();
			return inordertraversal (root, myiter).iterator();

		}
	}