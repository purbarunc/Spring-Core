package com.purbarun.springdata.repository;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.purbarun.springdata.beans.Person;
import com.purbarun.springdata.mappers.PersonMapper;

@Repository
public class PersonRepository {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	PersonMapper personMapper;

	public List<Person> findAll() {
		return jdbcTemplate.query("select * from person", personMapper);
	}

	public Person findById(int id) {
		return jdbcTemplate.queryForObject("select * from person where id=?", new Object[] { id }, personMapper);
	}

	public int deleteById(int id) {
		return jdbcTemplate.update("delete from person where id=?", new Object[] { id });
	}

	public int create(Person person) {
		return jdbcTemplate.update("insert into person(id,name,location,birthdate) values(?,?,?,?)", new Object[] {
				person.getId(), person.getName(), person.getLocation(), new Timestamp(person.getDob().getTime()) });
	}

	public int update(Person person) {
		return jdbcTemplate.update("update person set name=?, location=?, birthdate=? where id=?", new Object[] {
				person.getName(), person.getLocation(), new Timestamp(person.getDob().getTime()), person.getId() });

	}
}
