package org.library.media.serviceapi;

import org.junit.Test;
import org.library.media.domain.MediaCharacter;
import org.library.media.serviceapi.MediaCharacterService;
import org.sculptor.framework.test.AbstractDbUnitJpaTests;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

import java.util.List;

/**
 * Spring based transactional test with DbUnit support.
 */
public class MediaCharacterServiceTest extends AbstractDbUnitJpaTests implements MediaCharacterServiceTestBase {

	@Autowired
	protected MediaCharacterService mediaCharacterService;

	@Test
	public void testFindAll() throws Exception {
		
			List<MediaCharacter> media = mediaCharacterService.findAll(getServiceContext());
			assertNotNull(media);
		} 
		
	}
