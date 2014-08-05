package tests;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import student_classes.HashTbl;

public class StudentTests {

	HashTbl<String, Integer> temp;

	@Test
	public void test() {
		this.temp = new HashTbl<String, Integer>();
		assertFalse( this.temp==null );
		HashTbl<Integer, String> temp2 = new HashTbl<Integer, String>();
		assertFalse( temp2==null );
		Integer[] keys = gets( 100 );
		for( Integer key : keys )
			temp2.put( key, chooseTerm( (int)key % keys.length ));
		for( Integer key : keys ) {
			assertFalse( temp2.get(key)==null);
		}
		try {
			temp2.put( 0, null );
		}catch( NullPointerException npe ) {
			assertFalse( npe==null );
			return;
		}
		fail(" exception. ");
		this.temp = new HashTbl<String, Integer>();
		assertFalse( this.temp==null );
		this.temp.put( "1", 1 );
		Integer val = this.temp.get( "1" );
		assertTrue( val.equals( new Integer( 1 )));
	}
	private Integer[] gets( int howMany ) {
		Integer[] rgsInts = new Integer[ howMany ];
		for( int index=0; index < howMany; index++ ) 
			rgsInts[ index ] = new Integer( index );
		return rgsInts;
	}
	
	@Test
	public void testKeys() {
		HashTbl<Integer, String> funnyTable = new HashTbl<Integer, String>();
		assertNotNull( funnyTable );
		Integer[] keys = gets( 100 );
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
		Integer[] keys = gets( 100 );
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
	
	private static final String[] wordList = {"1", "2", "3", "4" , "5" , 
		"6", "7", "8", "9", "10" , "11", "12" , "13", "14" };
	
	private static String chooseTerm( int index ) {
		return wordList[ index % wordList.length ];
	}
	
}