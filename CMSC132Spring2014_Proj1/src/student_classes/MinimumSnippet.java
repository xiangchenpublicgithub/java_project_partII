package student_classes;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * When you do a web search, the results page shows you a 
 * <a href="http://searchengineland.com/anatomy-of-a-google-snippet-38357">snippet</a> 
 * for each result, showing you search terms in context. For purposes of this project, a
 * snippet is a subsequence of a document that contains all the search terms.
 * 
 * For this project, you will write code that, given a document (a sequence of
 * words) and set of search terms, finds the minimal length subsequence in the
 * document that contains all of the search terms.
 * 
 * If there are multiple subsequences that have the same minimal length, you may
 * return any one of them.
 * 
 */
public class MinimumSnippet {

	/**
	 * Compute minimum snippet.
	 * 
	 * Given a document (represented as an List<String>), and a set of terms
	 * (represented as a List<String>), find the shortest subsequence of the
	 * document that contains all of the terms.
	 * 
	 * This constructor should find the minimum snippet, and store information
	 * about the snippet in fields so that the methods can be called to query
	 * information about the snippet. All significant computation should be done
	 * during construction.
	 * 
	 * @@param document
	 *            The Document is an Iterable<String>. Do not change the
	 *            document. It is an Iterable, rather than a List, to allow for
	 *            implementations where we scan very large documents that are
	 *            not read entirely into memory. If you have problems figuring
	 *            out how to solve it with the document represented as an
	 *            Iterable, you may cast it to a List<String>; in all but a very
	 *            small number of test cases, in will in fact be a List<String>.
	 * 
	 * @@param terms
	 *            The terms you need to look for. The terms will be unique
	 *            (e.g., no term will be repeated), although you do not need to
	 *            check for that. There should always be at least one term and 
	 *            your code should
	 *            throw an <code>IllegalArgumentException</code> if "terms" is
	 *            empty.
	 * 
	 * 
	 */
	public MinimumSnippet(Iterable<String> document, List<String> terms) {
		
		HashSet<String> newTerms = new HashSet<String>(terms);
		if (terms.isEmpty())
			throw new IllegalArgumentException("Terms are empty");
		if (newTerms.size() < terms.size())
			throw new IllegalArgumentException("Terms are not unique");

		int[] arr = new int[terms.size()];
		int bestRange = Integer.MAX_VALUE;

		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.MIN_VALUE;
		}

		int index = -1;
		for (String a : document) {
			// index is now the index of s in the document
			index++; 
			int t = terms.indexOf(a);
			if (t < 0)
				// not a term
				continue; 

			arr[t] = index;
			int min = min(arr);
			if (min == Integer.MIN_VALUE)
				continue; 
			int scope = index - min + 1;
			if (bestRange > scope) {
				bestRange = scope;
				bestPos = Arrays.copyOf(arr, arr.length);
				startingPos = min;
				endingPos = index;
				if (bestRange == terms.size())
					return; 
			}

		}

	}
	private int[] bestPos;
	private int startingPos;
	private int endingPos;
	

	private int min(int[] pos) {
		int solution= Integer.MAX_VALUE;
		for (int a : pos)
			if (solution > a)
				solution = a;
		return solution;
	}

	private void check() {
		if (bestPos == null)
			throw new UnsupportedOperationException();
	}

	/**
	 * Returns whether or not all terms were found in the document. If all terms
	 * were not found, then none of the other methods should be called.
	 * 
	 * @@return whether all terms were found in the document.
	 */
	public boolean foundAllTerms() {
		return bestPos != null;
	}

	/**
	 * Return the starting position of the snippet
	 * 
	 * @@return the index in the document of the first element of the snippet
	 */
	public int getStartingPos() {
		check();
		return startingPos;
	}

	/**
	 * Return the ending position of the snippet
	 * 
	 * @@return the index in the document of the last element of the snippet
	 */
	public int getEndingPos() {
		check();
		return endingPos;
	}

	/**
	 * Return total number of elements contained in the snippet.
	 * 
	 * @@return an integer greater than or equal to 1
	 */
	public int getLength() {
		check();
		return 1+endingPos - startingPos ;

	}

	/**
	 * Returns the position of one of the search terms as it appears in the original document
	 * 
	 * @@param index index of the term in the original list of terms.  For example, if index
	 * is 0 then the method will return the position (in the document) of the first search term.
	 * If the index is 1, then the method will return the position (in the document) of the
	 * second search term.  Etc.
	 *  
	 * @@return position of the term in the document
	 */
	public int getPos(int index) {
		check();
		return bestPos[index];
	}

}
