package org.library.media.serviceapi;

import org.junit.Test;
import org.library.media.domain.Library;

import org.library.media.domain.Media;

import org.library.person.domain.Person;

import org.sculptor.framework.test.AbstractDbUnitJpaTests;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import static org.junit.Assert.*;

/**
 * Spring based transactional test with DbUnit support.
 */
public class LibraryServiceTest extends AbstractDbUnitJpaTests implements LibraryServiceTestBase {

	@Autowired
	protected LibraryService libraryService;

	@Test
	public void testFindLibraryByName() throws Exception {
		Library media = libraryService.findLibraryByName(getServiceContext(), "jano");
		assertNotNull(media);
		
	}

	@Test
	public void testFindMediaByName() throws Exception {
	Library media = libraryService.findLibraryByName(getServiceContext(), "Jano");
	assertNotNull(media);
	
	}

	@Test
	public void testFindMediaByCharacter() throws Exception {
	List<Media> media = libraryService.findMediaByCharacter(getServiceContext(), 14L, "Jano");
	assertNotNull(media);
	}

	@Test
	public void testFindPersonByName() throws Exception {
		List<Person> person = libraryService.findPersonByName(getServiceContext(), "Jano");
		assertNotNull(person);
	}

	@Test
	public void testFindById() throws Exception {
		Library id = libraryService.findById(getServiceContext(), 14L);
		assertNotNull(id);
	}

	@Test
	public void testFindAll() throws Exception {
	List<Library> media = libraryService.findAll(getServiceContext());
	assertNotNull(media);
	}

	@Test
	public void testSave() throws Exception {
		Library library = libraryService.findById(getServiceContext(), 14L);
		assertNotNull(library);
		
	}

	@Test
	public void testDelete() throws Exception {
		int before = countRowsInTable(Media.class);
		Library media = libraryService.findById(getServiceContext(), 14L);
		assertNotNull(media);
		libraryService.delete(getServiceContext(), media);
		assertEquals(before - 1, countRowsInTable(Media.class));
	}
}
