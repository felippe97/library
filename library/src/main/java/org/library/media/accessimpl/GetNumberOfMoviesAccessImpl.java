package org.library.media.accessimpl;

import org.library.person.domain.Person;
import org.sculptor.framework.accessimpl.jpa.JpaFindByCriteriaAccessImpl;

/**
 * Implementation of Access object for MediaRepository.getNumberOfMovies.
 *
 */
public class GetNumberOfMoviesAccessImpl extends GetNumberOfMoviesAccessImplBase {

	public void performExecute() {
		JpaFindByCriteriaAccessImpl<Person> finder = new JpaFindByCriteriaAccessImpl<Person>(Person.class);
		finder.setEntityManager(getEntityManager());
		finder.setOrderBy("name.last");
		finder.execute();
		setResult(finder.getResultCount().intValue());
	}
}