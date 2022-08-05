package org.library.person.repositoryimpl;

import java.util.List;
import org.library.person.domain.Person;
import org.library.person.domain.PersonProperties;
import org.sculptor.framework.accessapi.ConditionalCriteria;
import org.sculptor.framework.accessapi.ConditionalCriteriaBuilder;
import org.springframework.stereotype.Repository;

/**
 * Repository implementation for Person
 */
@Repository("personRepository")
public class PersonRepositoryImpl extends PersonRepositoryBase {

	public PersonRepositoryImpl() {
	}

	public List<Person> findPersonByName(String name) {
		List<ConditionalCriteria> criteria = ConditionalCriteriaBuilder.criteriaFor(Person.class)
				.withProperty(PersonProperties.name().first()).eq(name)
				.build();
		return findByCondition(criteria);
	}

}
