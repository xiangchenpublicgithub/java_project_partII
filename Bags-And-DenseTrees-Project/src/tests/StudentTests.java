package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import student_classes.DenseSearchTree;

public class StudentTests {
	// a place to design your own tests.
	@Test
	public void test() { 
		DenseSearchTree<Integer> t = new DenseSearchTree<Integer>();
		t.add(2);
		t.add(1);
		t.add(1);
		t.add(3);
		t.add(4);
		t.remove(3);
		System.out.print(t.count(1));
	}

}
