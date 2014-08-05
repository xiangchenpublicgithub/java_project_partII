package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import student_classes.DynArray;


/** 
 * Reserved for you to implement your own tests. Note: you may
 * need to add JUnit4 to your build path to use these. Ask 
 * your TA for help, or let Eclipse lead you through
 * the process.
 * 
 * @author CMSC Student
 *
 */
public class StudentTests {
	// uses these as you wish: they are "samples" of what kinds
	// of things are good test candidates.
	@Test
	public void testDynArrayBoolean() { //ctor
		DynArray<String> a=new DynArray<String>(true);
		a.add("test");
		a.add(null);
		assertTrue(a.get(0)=="test");
		assertTrue(a.get(1)==null);
		
		
		
	}

	@Test
	public void testDynArray() { //ctor
		DynArray<String> a=new DynArray<String>();
		a.add("test");
		a.add("test2");
		assertTrue(a.get(0)=="test");
		assertTrue(a.get(1)=="test2");
	}

	@Test
	public void testDynArrayIntBoolean() {
		DynArray<String> a=new DynArray<String>(8,true);
		a.add("test");
		a.add("test2");
		a.add(null);
		assertTrue(a.get(0)=="test");
		assertTrue(a.get(1)=="test2");
		assertTrue(a.get(2)==null);
	}

	@Test
	public void testAdd() {
		DynArray<String> a=new DynArray<String>();
		a.add("test");
		a.add("test2");
		assertTrue(a.get(0)=="test");
		assertTrue(a.get(1)=="test2");
	}

	@Test
	public void testRemove() {
		DynArray<String> a=new DynArray<String>();
		a.add("test");
		a.add("test2");
		a.add("test3");
		a.remove(1);
		assertTrue(a.get(0)=="test");
		assertTrue(a.get(1)=="test3");
	}

	@Test
	public void testGet() {
		DynArray<String> a=new DynArray<String>();
		a.add("test");
		a.add("test2");
		assertTrue(a.get(0)=="test");
		assertTrue(a.get(1)=="test2");
	}

	@Test
	public void testSet() {
		DynArray<String> a=new DynArray<String>();
		a.add("test");
		a.add("test2");
		a.set(1, "test3");
		assertTrue(a.get(0)=="test");
		assertTrue(a.get(1)=="test3");
	}

	@Test
	public void testSize() {
		DynArray<String> a=new DynArray<String>();
		a.add("test");
		a.add("test2");
		
		assertTrue(a.size()==2);
	
	}

}
