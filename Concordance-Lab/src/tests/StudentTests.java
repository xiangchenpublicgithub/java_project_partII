package tests;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Test;

import student_classes.Concordance;


/* Feel free to add your own tests here ... 
 * Bear in mind that sample.txt should already be in your
 * project, if you'd like to reuse it. Or, you might
 * come up with your own text file(s)?
 */
public class StudentTests {
	@Test
	public void test(){
		Concordance cord = null;
		try {
			cord = new Concordance ("sample.txt", true );
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(cord.getTokenCount("app"), 3);
		System.out.print(cord.getTokensByCount(3));
	}
	
}
