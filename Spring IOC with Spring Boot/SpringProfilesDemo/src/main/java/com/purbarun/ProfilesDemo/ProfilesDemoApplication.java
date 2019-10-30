package com.purbarun.ProfilesDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.purbarun.ProfilesDemo.search.BinarySearch;

@SpringBootApplication
public class ProfilesDemoApplication {

	public static void main(String[] args) {
		ApplicationContext ctx= SpringApplication.run(ProfilesDemoApplication.class, args);
		BinarySearch binarySearch=ctx.getBean(BinarySearch.class);
		System.out.println(binarySearch);
		int result = binarySearch.binarySearch(new int[] { 2, 8, 1, 5 }, 1);
		System.out.println("Number Found At " + (result + 1) + " position");
	}
}
