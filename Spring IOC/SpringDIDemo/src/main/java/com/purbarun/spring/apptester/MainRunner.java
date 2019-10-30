package com.purbarun.spring.apptester;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.purbarun.spring.search.BinarySearch;

@ComponentScan(basePackages = "com.purbarun.spring")
public class MainRunner {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainRunner.class);
		BinarySearch binarySearch = applicationContext.getBean(BinarySearch.class);
		System.out.println(binarySearch);
		int result = binarySearch.binarySearch(new int[] { 2, 8, 1, 5 }, 1);
		System.out.println("Number Found At " + (result + 1) + " position");
		((ConfigurableApplicationContext) applicationContext).close();
	}
}
