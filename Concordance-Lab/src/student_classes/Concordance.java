/**
 * Note to Staff who might read this file: I intentionally used a different coding style in order to 
 * quickly discriminate my code from other's. This project is intended to be used by the CMSC132H 
 * class to easily experiment with tables (dictionary) structures and the regular expressions 
 * package ... .
 */
package student_classes;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Hashtable;
//import java.util.Iterator;
import java.util.Scanner;
import java.util.regex.Pattern;

// imports should go here ... depending upon your approach ...
// I strongly advise java.util.Scanner, java.util.regex, and most likely
// a dictionary class, such as HashTable.

/**
 * @author Tom R:
 * A <code>Concordance</code> is an object that embodies the association of tokens (words taken from a text) 
 * to their "context." This class defines "context"  as the the number of
 * times that a particular token (word) occurs in a document (which is a text file). 
 * <P>
 * Clients of this class provide a complete pathname to a text file (<file>.txt) and
 * a boolean variable <code>is_case_sensitive</code> that determines whether tokens are stored in
 * the original case or are converted to lower case during the construction of the 
 * associations as well as during the retrieval of counts associated with particular
 * tokens. </P>
 * <P>Clients may
 * use the various methods on the <code>Concordance</code> object to retrieve information such as how
 * many times a particular word occurred or lists of words that occurred a number of times.
 * </P>
 * <P>
 * <strong>
 * Special characters, such as syntax marks, are ignored. It is possible, therefore, that hyphenated
 * words or contractions will register incorrectly: For example: "can't" might be "can" "t." Certainly,
 * developers of this class are encouraged to explore Java's regular expressions package to 
 * improve this implementation!</strong>
 * </P>
 *
 */
public class Concordance {
// Properties:
	
//	Constructor(s):
	/**
	 * Default ctor: sets up internal tables ... not usefully called by 
	 * anyone outside of this class.
	 */
	private Hashtable<String,Integer> dic;
	private boolean isCaseSensitive;
	
	protected Concordance( ) {
		 dic= new Hashtable<String, Integer>();
	}
	/**
	 * Main Constructor: requires two parameters: 
	 * <P>
	 * (1) <code>pathName</code> is a <code>String</code> representing a valid pathname, i.e., a pathname
	 * whose last component is the name of a "text file." Text files comprise normal characters and are
	 * assumed to have the suffix "<filename>.txt".
	 * <P>
	 * (2) <code> is_case_sensitive</code>, which is a <code>boolean</code>
	 * that determines if the capitalization of tokens matters. If the client specifies that
	 * <code>is_case_sensitive</code> is <code>True</code>, then the original case of all tokens will be preserved during the
	 * construction of the tables (associations) as well as during the retrieval of data that involves
	 * the comparison of tokens by the various public methods exposed by the Concordance object.</item>
	 * </P>
	 * @param pathName (String)
	 * @param is_case_sensitive (boolean)
	 * @throws FileNotFoundException 
	 */
	public Concordance( String pathName, boolean is_case_sensitive ) throws FileNotFoundException {
		this();
		Scanner in = new Scanner (new File (pathName));
		Pattern p = Pattern.compile("\\W+");
		isCaseSensitive = is_case_sensitive;
		
		while(in.hasNext()){
			//String str = in.next();
			String[] words = p.split(in.nextLine()); 
			for (String str : words) {
				if (!isCaseSensitive) str = str.toLowerCase(); 
				if (!dic.containsKey(str)) 
					dic.put(str, 1); 
				else
					dic.put(str, dic.get(str) + 1);
			}
		}
	}
	/**<P>
	 * Given a (String) token, return how many times it occurred in the text.</P>
	 * <P>Preconditions: The constructor has been successfully called.</P>
	 * <P>Postconditions: a counting number is returned.</P>
	 * <P> Note: this method is sensitive to 
	 * the value of the <code>is_case_sensitive</code> parameter that the user specified during the 
	 * construction of this instance. If the user specified that case was to be ignored,
	 * then all tokens have been installed and will be compared in lower case; otherwise, 
	 * the original case of the token(s) as they were found in the document will be used.
	 */
	public int getTokenCount( String for_token ) {
		if (!isCaseSensitive) for_token = for_token.toLowerCase(); 
		
		if (dic.containsKey(for_token)) {
			return dic.get(for_token);
		} else {
			return 0;
		}
	}
	/**
	 * <P>Preconditions: The Constructor has successfully been called. Note: the <code>by_count</code>
	 * argument must be an integer greater than 0 or an Illegal Argument exception is thrown.</P>
	 * <P>
	 * Postcondition: An <code>Iterable(String)</code> object is returned that contains an unordered
	 * list of tokens (which are unique) whose counts equal <code>by_count</code> Note: this list
	 * could be empty, but should not be under ordinary circumstances.</P>
	 * @param by_count <code>(int > 0)</code>
	 * @return <code>Iterable(String)</code> An Iterable<String> object (which may be empty) that contains the tokens whose counts
	 * equal the <code>by_count</code> (int) parameter.
	 */
	public Iterable<String> getTokensByCount( int by_count ) {
		ArrayList<String> aList = new ArrayList<String>();
		if (by_count <= 0) throw new IllegalArgumentException();
		
		for (String a : dic.keySet()){
			if (dic.get(a) == by_count) aList.add(a);
		}
		return aList;
	}
	/**
	 * <P>Preconditions: The Constructor for this class has been successfully called.
	 * </P>
	 * <P>Postconditions: The current size, which is the number of entries, in the Concordance table is returned.
	 * @return<code> int>= 0</code>
	 */
	public final int size() {
		return dic.size();
	}
	
	/**
	 * Returns a String that identifies this object and provides a little detail ...
	 */
	public String toString() { 
		return dic.toString();
	}
	
}
