package tests;

import static org.junit.Assert.*;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

import student_classes.BasicSet;
import student_classes.EmptySet;
import student_classes.NonEmptySet;
/**
 * Provided for you to create your own tests. You will most likely
 * need to import your set classes before you begin.
 * @author UMD CS Dept.
 *
 */
public class StudentTests {
	@Test
	public void test() {
		List<String> test1 = new LinkedList<String>();
		test1.add("1");
		test1.add("2");
		test1.add("3");
		test1.add("4");
		NonEmptySet <String> temp1 =new NonEmptySet <String> (test1);
		NonEmptySet <String> temp2 =new NonEmptySet <String> (temp1);
		System.out.println(temp2);
		assertTrue(temp1.size()==4);
		assertTrue(temp1.isMember("2"));
		List<String> test2 = new LinkedList<String>();
		test2.add("1");
		test2.add("2");
		test2.add("3");
		NonEmptySet <String> temp3 =new NonEmptySet <String> (test2);
		assertTrue(temp3.isSubset(temp1));
		EmptySet <String> temp4 =new EmptySet <String> ();
		assertTrue(temp4.isSubset(temp1));
		assertTrue((temp1.union(temp3)).equals(temp1));
		assertTrue((temp1.union(temp4)).equals(temp1));
		assertTrue((temp1.intersection(temp3)).equals(temp3));
		assertTrue((temp1.intersection(temp4)).equals(temp4));
		List<String> test3 = new LinkedList<String>();
		test3.add("4");
		NonEmptySet <String> temp5 =new NonEmptySet <String> (test3);
		assertTrue((temp1.setDifference(temp3)).equals(temp5));
		assertTrue((temp1.setDifference(temp4)).equals(temp1));
	}

}
