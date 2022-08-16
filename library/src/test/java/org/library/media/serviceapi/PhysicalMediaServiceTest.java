package org.library.media.serviceapi;

import org.junit.Test;

import org.library.media.domain.PhysicalMedia;

import org.sculptor.framework.test.AbstractDbUnitJpaTests;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

import java.util.List;


/**
 * Spring based transactional test with DbUnit support.
 */
public class PhysicalMediaServiceTest extends AbstractDbUnitJpaTests implements PhysicalMediaServiceTestBase {

	@Autowired
	protected PhysicalMediaService physicalMediaService;

	@Test
	public void testFindById() throws Exception {
		PhysicalMedia media = physicalMediaService.findById(getServiceContext(), 14L);
		assertNotNull(media);
	}

	@Test
	public void testFindAll() throws Exception {
	List<PhysicalMedia> media = physicalMediaService.findAll(getServiceContext());
	assertNotNull(media);
	
	}

	@Test
	public void testSave() throws Exception {
		PhysicalMedia media = physicalMediaService.findById(getServiceContext(), 14L);
		assertNotNull(media);
		media.setVersion(15L);
		physicalMediaService.save(getServiceContext(), media);
		PhysicalMedia media1 = physicalMediaService.findById(getServiceContext(), 14L);
		assertEquals("Zem", media1.getVersion());
	}

	@Test
	public void testDelete() throws Exception {
		int before = countRowsInTable(PhysicalMedia.class);
		PhysicalMedia media = physicalMediaService.findById(getServiceContext(), 14L);
		assertNotNull(media);
		physicalMediaService.delete(getServiceContext(), media);
		assertEquals(before - 1, countRowsInTable(PhysicalMedia.class));
	}
}
