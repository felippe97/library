package org.library.media.repositoryimpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.library.media.domain.Library;
import org.library.media.domain.LibraryProperties;
import org.library.media.domain.Media;
import org.library.media.domain.MediaProperties;
import org.sculptor.framework.accessapi.ConditionalCriteria;
import org.sculptor.framework.accessapi.ConditionalCriteriaBuilder;
import org.sculptor.framework.accessapi.FindByCriteriaAccess;
import org.springframework.stereotype.Repository;

/**
 * Repository implementation for Library
 */
@Repository("libraryRepository")
public class LibraryRepositoryImpl extends LibraryRepositoryBase {

	public LibraryRepositoryImpl() {
	}

	public Library findLibraryByName(String name) {
		List<ConditionalCriteria> criteria = ConditionalCriteriaBuilder.criteriaFor(Library.class)
				.withProperty(LibraryProperties.name()).eq(name).build();

		
		List<Library> result = findByCondition(criteria); return result.size() > 0 ?
		result.get(0) : null;
		

	}
}