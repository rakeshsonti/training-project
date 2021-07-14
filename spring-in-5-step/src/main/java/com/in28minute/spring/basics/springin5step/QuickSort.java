package com.in28minute.spring.basics.springin5step;

import java.util.Arrays;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;


@Component
@Primary
public class QuickSort implements SortAlgorithm {
public int [] sort(int []numbers) {
	Arrays.sort(numbers);
	return numbers;
}
}
