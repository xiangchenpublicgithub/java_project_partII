package student_classes;

import java.util.Scanner;

public class ExampleCode {
	
	private static String[] directions = {"north", "east", "south", "west" };
	
	public static int indexOf( String target ) {
		for( int index=0; index < directions.length; index++ ) 
			if( directions[index].equalsIgnoreCase( target ) ) 
				return index;
		return -1;
	}
	
	public static String reverseDirection( String direction ) {
		int index = indexOf( direction );
		if( index < 0 ) 
			throw new IllegalArgumentException();
		return directions[ (index + 2) % 4 ];
	}
	
	public static void printReverseDirection( String direction ) {
		String reversedDirection = null;
		try {
			reversedDirection = reverseDirection( direction );
		}catch( IllegalArgumentException exp ) {
			System.err.println("bad direction " + direction );
		}
		System.out.println("Original direction was " + direction + " and its inverse is " + reversedDirection );
	}
	
	public static void main( String[] args ) {
		Scanner in = new Scanner( System.in );
		System.out.println("Enter a direction: north, east, south, west " );
		String dir = in.next();
		printReverseDirection( dir );
	}

}
