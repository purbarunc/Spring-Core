package com.purbarun.springdata.apptester;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.purbarun.springdata.beans.Person;
import com.purbarun.springdata.repository.PersonRepository;

@SpringBootApplication(scanBasePackages = "com.purbarun.springdata")
public class MainRunner implements CommandLineRunner {
	@Autowired
	private PersonRepository personDao;

	public static void main(String[] args) {
		SpringApplication.run(MainRunner.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("All Persons: " + personDao.findAll());
		System.out.println("Person with User Id 10000: " + personDao.findById(10000));
		System.out.println(
				"No. of rows created: " + personDao.create(new Person(10004, "Rajesh", "Chennai", new Date())));
		System.out.println("No. of row updated: " + personDao.update(new Person(10001, "Ramesh", "Delhi", new Date())));
		System.out.println("No. of row deleted: " + personDao.deleteById(10002));
	}
}
