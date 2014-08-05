package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import student_classes.InPlaceList;

public class PublicTests {

	InPlaceList<String> names;

	@Test
	public void testInPlaceList() {
		this.names = new InPlaceList<String>();
		assertNotNull( this.names );
	}

	@Test
	public void testIsEmpty() {
		this.names = new InPlaceList<String>();
		assertNotNull( this.names );
		assertTrue( this.names.isEmpty() );
	}

	@Test
	public void testSize() {
		this.names = new InPlaceList<String>();
		assertNotNull( this.names );
		assertTrue( this.names.isEmpty() );
		String[] testNames = { "Bob", "Carol", "Ted", "Alice" };
		for ( String aName : testNames ) 
			this.names.add( aName );
		assertEquals( this.names.size(), 4 );
	}

	@Test
	public void testAdd() {
		this.names = new InPlaceList<String>();
		assertNotNull( this.names );
		assertTrue( this.names.isEmpty() );
		String[] testNames = { "Bob", "Carol", "Ted", "Alice" };
		for ( String aName : testNames ) 
			this.names.add( aName );
		
		System.out.println("This indirectly ensures that toString is working: " + this.names );
	}
	
	@Test
	public void testRemove() {
		this.names = new InPlaceList<String>();
		assertNotNull( this.names );
		assertTrue( this.names.isEmpty() );
		String[] testNames = { "Bob", "Carol", "Ted", "Alice" };
		for ( String aName : testNames ) 
			this.names.add( aName );
		System.out.println("Newly created list of names is " + this.names );
		this.names.remove( "Ted" );
		System.out.println("After removing Ted... " + this.names );
		assertEquals( this.names.size(), 3 );
		String[] dittoNames = { "Bob", "Bob", "Carol", "Carol" };
		this.names = new InPlaceList<String>();
		for( String aName : dittoNames ) 
			this.names.add( aName );
		System.out.println("List is now : " + this.names );
		this.names.remove( "Bob" );
		System.out.println("Removed Bob ... " + this.names );
		assertEquals( this.names.size(), 2 );
		this.names.remove( "Carol");
		assertEquals( this.names.size(), 0 );
		assertTrue( this.names.isEmpty() );
	}
	
	@Test
	public void testReverse() {
		this.names = new InPlaceList<String>();
		assertNotNull( this.names );
		assertTrue( this.names.isEmpty() );
		String[] testNames = { "Bob", "Carol", "Ted", "Alice" };
		for ( String aName : testNames ) 
			this.names.add( aName );
		System.out.println("Newly created list of names is " + this.names );
		this.names.reverse();
		System.out.println("Reversed " + this.names );
	}
}

