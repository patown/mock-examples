package com.github.springtestdbunit.sample.service;

import static org.junit.Assert.assertEquals;

import java.util.List;


import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.ExpectedDatabase;
import com.github.springtestdbunit.sample.TestCaseBase;
import com.github.springtestdbunit.sample.entity.Person;

public class PersonServiceTest extends TestCaseBase{

	@Autowired
	private PersonService personService;

	
	@Test
	@DatabaseSetup("sampleData.xml")
	public void testFind() throws Exception {
		List<Person> personList = this.personService.find("hil");
		assertEquals(1, personList.size());
		assertEquals("Phillip", personList.get(0).getFirstName());
	}

	@Test
	@DatabaseSetup("sampleData.xml")
	@ExpectedDatabase("expectedData.xml")
	public void testRemove() throws Exception {
		this.personService.remove(1);
	}

}
