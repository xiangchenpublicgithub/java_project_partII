package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import student_classes.HashTbl;
import java.util.Random;

import java.util.Iterator;

public class PublicTests {
	HashTbl<String, Integer> countTable;

	@Test
	public void testHashTbl() {
		this.countTable = new HashTbl<String, Integer>();
		assertNotNull( this.countTable );
	}

	@Test
	public void testPut() {
		HashTbl<Integer, String> funnyTable = new HashTbl<Integer, String>();
		assertNotNull( funnyTable );
		Integer[] keys = genInts( 100 );
		for( Integer key : keys )
			funnyTable.put( key, chooseTerm( (int)key % keys.length ));
		for( Integer key : keys ) {
			assertNotNull( funnyTable.get(key));
		}
		/* test for null pointer */
		try {
			funnyTable.put( 0, null );
		}catch( NullPointerException npe ) {
			assertNotNull( npe );
			return;
		}
		fail("didn't throw null pointer exception. ");
	}

	@Test
	public void testGet() {
		this.countTable = new HashTbl<String, Integer>();
		assertNotNull( this.countTable );
		this.countTable.put( "Tom", 1 );
		Integer val = this.countTable.get( "Tom" );
		assertTrue( val.equals( new Integer( 1 )));
	}
	
	/* to assist with testing */
	private Integer[] genInts( int howMany ) {
		Integer[] rgsInts = new Integer[ howMany ];
		for( int index=0; index < howMany; index++ ) 
			rgsInts[ index ] = new Integer( index );
		return rgsInts;
	}
	
	@Test
	public void testKeys() {
		HashTbl<Integer, String> funnyTable = new HashTbl<Integer, String>();
		assertNotNull( funnyTable );
		Integer[] keys = genInts( 100 );
		for( Integer key : keys )
			funnyTable.put( key, chooseTerm( (int)key % keys.length ));
		Iterator<Integer> keyIterator = funnyTable.keys();
	
		while( keyIterator.hasNext() ) {
			Integer key = keyIterator.next();
			assertEquals( funnyTable.get( key ), 
					chooseTerm ( (int)key % keys.length  ) );
		}
	}
	
	@Test
	public void testValues() {
		HashTbl<Integer, String> funnyTable = new HashTbl<Integer, String>();
		assertNotNull( funnyTable );
		Integer[] keys = genInts( 100 );
		for( Integer key : keys )
			funnyTable.put( key, chooseTerm( (int)key % keys.length ));
		Iterator<String> valuesIterator = funnyTable.values();
		int count = 0;
		while( valuesIterator.hasNext() ) {
			count++;
			valuesIterator.next();
		}
		assertEquals( count, 100 );
	}
	
	private static final String[] wordList = {"Peter", "Piper", "picked", "a" , "peck" , 
		"of", "picked", "peppers", "how", "many" , "peppers", "did" , "he", "pick" };
	
	private static String chooseTerm( int index ) {
		return wordList[ index % wordList.length ];
	}
	

}
