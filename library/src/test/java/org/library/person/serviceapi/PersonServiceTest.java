package org.library.person.serviceapi;

import org.junit.Test;
import org.library.person.domain.Person;

import org.library.person.domain.PersonName;

import org.sculptor.framework.test.AbstractDbUnitJpaTests;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;



import java.util.List;


import javax.sql.DataSource;

import org.junit.Before;

/**
 * Spring based transactional test with DbUnit support.
 */
public class PersonServiceTest extends AbstractDbUnitJpaTests implements PersonServiceTestBase {

	@Autowired
	protected PersonService personService;
	@Autowired
	DataSource source;

	@Before
    public void setDataSource() {
        super.setDataSource(source);
    }
	
	@Before
	public void setUpDatabaseTester() throws Exception {
		super.setUpDatabaseTester();
	}
	
	@Test
	public void testFindPersonByName() throws Exception {		
		List<Person> person = personService.findPersonByName(getServiceContext(), "Jano");
		assertNotNull(person);
		
			
	}

	@Test
	public void testFindById() throws Exception {
	Person person = personService.findById(getServiceContext(), 14L);
			assertNotNull(person);
	}

	@Test
	public void testFindAll() throws Exception {
		List<Person> person = personService.findAll(getServiceContext());
		assertNotNull(person);
		
	}

	@Test
	public void testSave() throws Exception {
		Person person = personService.findById(getServiceContext(), 14L);
		assertNotNull(person);
		PersonName name = new PersonName("Jano", "KUKU");
		person.setName(name);
		personService.save(getServiceContext(), person);
		Person person2 = personService.findById(getServiceContext(), 14L);
		assertEquals("Jano", person2.getName().getFirst());
	}

	@Test
	public void testDelete() throws Exception {
		int before = countRowsInTable(Person.class);
		Person person = personService.findById(getServiceContext(), 14L);
		assertNotNull(person);
		personService.delete(getServiceContext(), person);
		assertEquals(before - 1, countRowsInTable(Person.class));
		
	}
}
