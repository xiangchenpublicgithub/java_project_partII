package tests;
/*
 * Under NO circumstances should you mess with these package definitions
 * or the following import statements. Leave them alone!
 */
import static org.junit.Assert.*;

import org.junit.Test;

import utilities.LList;

import static utilities.LList.*;
import static student_classes.ListFunctions.*;
/* 
 * Define your student tests here. I've provided a simple
 * function as a template, to get you started.
 * 
 */
public class StudentTests {

	@Test
	public void testReverse() {
		LList myList = LList();
		for( int index=0; index < 10; index++ ) 
			myList = cons( index, myList );
		LList myList2 = LList();
		for( int index=10; index < 20; index++ ) 
			myList2 = cons( index, myList2 );
		System.out.println("Created " + myList );
		System.out.println("Created " + myList );
		assertEquals( length( myList ), 10 );
		myList = reverse( myList );
		System.out.println("Reversed it is " + myList );
		assertEquals( length( myList ), 10 );
		myList = lastn(10,myList);
		System.out.println(" it is " + myList );
		
	}

}
