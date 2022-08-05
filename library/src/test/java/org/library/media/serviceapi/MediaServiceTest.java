package org.library.media.serviceapi;

import org.junit.Test;
import org.library.media.domain.Media;

import org.sculptor.framework.test.AbstractDbUnitJpaTests;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

import java.util.List;

/**
 * Spring based transactional test with DbUnit support.
 */
public class MediaServiceTest extends AbstractDbUnitJpaTests implements MediaServiceTestBase {

	@Autowired
	protected MediaService mediaService;

	@Test
	public void testFindAll() throws Exception {
		List<Media> media = mediaService.findAll(getServiceContext());
		assertNotNull(media);
	}
}
