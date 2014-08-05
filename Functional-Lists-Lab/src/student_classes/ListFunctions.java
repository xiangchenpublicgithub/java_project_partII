package student_classes;
import static utilities.LList.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import utilities.*;
/*
 * Under NO circumstances should you mess with the import statements
 * directly above!
 */

/**
 * Define all of your methods in this class, using the static imports from the
 * LListLib.jar file, which is attached to the project. 
 * 
 * @author UMD CS Dept.
 *
 */
public class ListFunctions {
	
	/**
	 * An example of using the LList library to define a common list function:
	 * this one reverses the elements of a LList.
	 * @param list
	 * @return
	 */
	
	public static <T> LList<T> reverse( LList<T> list ) {
		if( isEmpty(list) ) return list;
		else return reverse_aux( list, LList());
	}
	/*
	 * Note the "pattern here." Normally, you define the "top level" function
	 * as we did for "reverse" --above. Then we "delegate" to a private 
	 * auxiliary to do the work. Sometimes you can skip the aux and implement
	 * the function directly, using only the primitives from the library.
	 * In this case, however, because cons only "goes one way," we had to 
	 * resort to this.
	 */
	private static <T> LList<T> reverse_aux( LList<T> list, LList reversed_list ) {
		if( isEmpty( list ) ) return reversed_list;
		else return reverse_aux( rest( list ), cons( first( list ), reversed_list ) );
	}
	/**
	 * Performs the standard "merge sort" on two lists.
	 * @param list
	 * @return
	 */
	public static <T extends Comparable<T> > LList<T>  msort( LList<T> list ) {
		LList<T> temp = null;
		List<T> newList = new ArrayList<T>();
		while( first(list)!=null){
			newList.add(first(list));
			list = rest( list );
			if (list == null) break; 
		}
		Collections.sort( newList );
		for(T a: newList)
			temp = cons(a, temp);
	    return temp;
		
		
		
		
				
		
	}
	public static <T> LList<T> member( T ele, LList<T> list ) {
		if( isEmpty( list ) ) return list;
		else if( ( first( list ).equals( ele ) ) )
		return cons( first( list ),member( ele, rest( list )));
		else
		return member( ele, rest( list ) );
		}
	public static <T> LList<T> union( LList<T> set1, LList<T> set2 ) {
		if( isEmpty( set1 ) ) return set2;
		else if( member( first( set1), set2)!=null)
		return union( rest( set1 ), set2 );
		else
		return cons( first( set1 ),union( rest( set1), set2 ) );
		}
	/**
	 * Given two semi-sorted lists, merge them into a new list by comparing the
	 * head of each list and taking the appropriate actions.
	 * @param list1
	 * @param list2
	 * @return
	 */
	public static <T extends Comparable<T> > LList<T> merge( LList<T> list1, LList<T> list2 ) {
		if ( first ( list1).compareTo(first( list2)) < 0) return union (list1,list2);
		else return union( list2, list1);
	}
	/**
	 * Returns the first "n" elements from list:
	 * 
	 * firstn( 0, [1,2,3] ) => []
	 * firstn( 1, [1,2,3] ) => [1]
	 * firstn( 2, [1,2,3] ) => [1, 2], etc.
	 * 
	 * Observe that firstn(0, [1,2,3]) returns null (or the empty
	 * list). In your implementation: just return the "list" parameter.
	 * @param n
	 * @param list
	 * @return
	 */
	public static <T> LList<T> firstn( int n, LList<T> list ) {
		if ( n == 0 ) return null;
		LList<T> newList = null;
		for(int i = 0; i < n; i++){
		newList = cons(first(list), newList);
		list = rest(list);
		}
		return newList;
	}
	/**
	 * Returns the last "n" elements from list:
	 * 
	 * lastn( 0, [1,2,3] ) => [1,2,3]
	 * lastn( 1, [1,2,3] ) => [3]
	 * lastn( 2, [1,2,3] ) => [2,3]
	 * 
	 * @param n
	 * @param list
	 * @return
	 */
	public static <T> LList<T> lastn( int n, LList<T> list ) {
		if ( n == 0 ) return list;
		else return lastn(n-1,rest(list));
		
	}

}
