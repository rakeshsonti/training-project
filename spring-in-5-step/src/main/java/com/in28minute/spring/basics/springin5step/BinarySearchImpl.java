package com.in28minute.spring.basics.springin5step;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class BinarySearchImpl  {
	
	private SortAlgorithm sortAlgo;
	/**
	 * @param sortAlgo
	 */
//	public BinarySearchImpl(SortAlgorithm sortAlgo) {
//		super();
//		this.sortAlgo = sortAlgo;
//	}
	@Autowired
	public void setSortAlgo(SortAlgorithm sortAlgo) {
		this.sortAlgo = sortAlgo;
	}
	
	public int binarySearch(int []numbers,int numberToSearch) {
		//BubbleSort bubbleSort=new BubbleSort();
		int [] newArray=sortAlgo.sort(numbers);
		// sorting an array
		System.out.println(Arrays.toString(newArray));
		//search the array
		
		// return the result
		return 3;
	}
	
	
}
