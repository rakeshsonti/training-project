package com.in28minute.spring.basics.springin5step;

import java.util.Arrays;

import org.springframework.stereotype.Component;
@Component
public class BubbleSort implements SortAlgorithm {
public int [] sort(int []numbers) {
	Arrays.sort(numbers);
	return numbers;
}
}
