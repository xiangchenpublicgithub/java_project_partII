package tests;

import static org.junit.Assert.*;
import listClasses.BasicLinkedList;

import java.util.Comparator;

import listClasses.BasicLinkedList;
import listClasses.SortedLinkedList;

import org.junit.Test;

public class StudentTests {

	@Test
	public void test() {
		BasicLinkedList<String > temp=new BasicLinkedList<String>();
		
		assertEquals(temp.getLast(),null);
		assertTrue(temp.getFirst()==null);
		//assertTrue(temp.getLast()==null);
		//assertTrue(temp.getSize()==0);
		temp.addToFront("A");
		temp.addToFront("2");
		temp.addToFront("3");
		temp.addToEnd("4");
		temp.addToEnd("5");
		temp.remove("3", String.CASE_INSENSITIVE_ORDER);
		temp.remove("A", String.CASE_INSENSITIVE_ORDER);
		//System.out.print(temp.getFirst());
		assertEquals(temp.getFirst(),"2");
		temp.remove("5", String.CASE_INSENSITIVE_ORDER);
		assertEquals(temp.getLast(),"4");
		assertTrue(temp.getSize()==2);
		//temp.addToEnd("3");
		//temp.addToEnd("4");
		assertEquals(temp.getFirst(),"3");
		assertEquals(temp.getLast(),"5");
		assertTrue(temp.getSize()==5);
		assertEquals(temp.retrieveFirstElement(),"1");
		assertEquals(temp.retrieveLastElement(),"4");
		temp.remove("1", String.CASE_INSENSITIVE_ORDER);
		
		assertEquals(temp.getFirst(),"2");
		assertEquals(temp.getLast(),"3");
		for (String entry : temp) {
			assertEquals(entry,"2");
			
		}
		SortedLinkedList<String > newTemp=new SortedLinkedList<String>(String.CASE_INSENSITIVE_ORDER);
		assertEquals(newTemp.getFirst(),null);
		assertEquals(newTemp.getLast(),null);
		newTemp.add("C").add("B").add("A");
		assertEquals(newTemp.getFirst(),"A");
		assertEquals(newTemp.getLast(),"C");
		newTemp.remove("A");
		newTemp.remove("C");
		assertEquals(newTemp.getFirst(),"B");
		assertEquals(newTemp.getLast(),"B");
		for (String entry : newTemp) {
			assertEquals(entry,"B");
			
		}
		
		
		
	}

}
