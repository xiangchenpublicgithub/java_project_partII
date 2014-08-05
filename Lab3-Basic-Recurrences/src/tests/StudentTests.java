package  tests;

import static org.junit.Assert.*;
import student_classes.Recurrences;

import org.junit.Test;

public class StudentTests {

	@Test
	public void testPower() { 
		assertTrue(Recurrences.power(2, 2)==4);
		assertTrue(Recurrences.power(2, 3)==8);
		assertTrue(Recurrences.power(2, 4)==16);
		assertTrue(Recurrences.power(1, 2)==1);
		assertTrue(Recurrences.power(500, 0)==1);
		assertTrue(Recurrences.power(10, 2)==100);
	}
	@Test
	public void testFactorial() { 
		assertTrue(Recurrences.factorial(0)==1);
		assertTrue(Recurrences.factorial(2)==2);
		assertTrue(Recurrences.factorial(3)==6);
		assertTrue(Recurrences.factorial(7)==5040);
		assertTrue(Recurrences.factorial(4)==24);
		assertTrue(Recurrences.factorial(9)==362880);
	}
	
	@Test
	public void testFibonacci() { 
		assertTrue(Recurrences.fibonacci(1)==1);
		assertTrue(Recurrences.fibonacci(2)==1);
		assertTrue(Recurrences.fibonacci(3)==2);
		assertTrue(Recurrences.fibonacci(4)==3);
		assertTrue(Recurrences.fibonacci(5)==5);
		assertTrue(Recurrences.fibonacci(9)==34);
	}
	@Test
	public void testGcd() { 
		assertTrue(Recurrences.gcd(1,10)==1);
		assertTrue(Recurrences.gcd(5,25)==5);
		assertTrue(Recurrences.gcd(30,60)==30);
		assertTrue(Recurrences.gcd(6,9)==3);
		assertTrue(Recurrences.gcd(21,35)==7);
		assertTrue(Recurrences.gcd(9,81)==9);
	}
	@Test
	public void testPmod() { 
		assertTrue(Recurrences.pmod(1,10)==1);
		assertTrue(Recurrences.pmod(25,5)==0);
		assertTrue(Recurrences.pmod(30,3)==0);
		assertTrue(Recurrences.pmod(9,2)==1);
		assertTrue(Recurrences.pmod(15,7)==15%7);
		assertTrue(Recurrences.pmod(16,7)==16%7);
	}
	@Test
	public void testGenerateOdd() { 
		assertTrue(Recurrences.generateOdds(1)[0]==1);
		assertTrue(Recurrences.generateOdds(2)[1]==3);
		assertTrue(Recurrences.generateOdds(3)[2]==5);
		assertTrue(Recurrences.generateOdds(4)[3]==7);
		assertTrue(Recurrences.generateOdds(5)[4]==9);
		assertTrue(Recurrences.generateOdds(6)[5]==11);
	}
	@Test
	public void testCountEvens() { 
		int[] test= {1,2,3,4,5,6,7,8,9};
		int[] test2={2,4,6,8};
		int[] test3={20,13,24};
		assertTrue(Recurrences.countEvens(test)==4);
		assertTrue(Recurrences.countEvens(test2)==4);
		assertTrue(Recurrences.countEvens(test3)==2);
	}
}