package com.in28minute.spring.basics.springin5step;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringIn5StepApplication {
	//what are beans
	//using add component anotation
	//what are the dependencies of bean
	//using autowired
	//where to search for beans
	//took from application context
	
	
	
	public static void main(String[] args) {
		//BinarySearchImpl binarySearch=new BinarySearchImpl(new QuickSort());
		//Application Context
		
	ApplicationContext applicationContext=	SpringApplication.run(SpringIn5StepApplication.class, args);
	BinarySearchImpl binarySearch=applicationContext.getBean(BinarySearchImpl.class);	
	int result=binarySearch.binarySearch(new int[] {5,2,4,1,45},4);
		System.out.println(result);
		
	}

}
