package tests;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.Test;

import student_classes.Heap;

public class StudentTests { // these are merely suggestions ....
	
	@Test
	public void testHeap() {
		// merely a suggestion 
		int a[]={16,7,3,20,17,8};
		ArrayList aList=new ArrayList();
		for(int i=0;i<a.length;i++)
			aList.add(a[i]);
		new Heap(aList).sort();
		
		//System.out.print(newHeap);
		
	}

	@Test
	public void testSort() {
		
	}

	@Test
	public void testSize() {
		
	}
	
	@Test
	public void testAsList() { 
		
	}

}
