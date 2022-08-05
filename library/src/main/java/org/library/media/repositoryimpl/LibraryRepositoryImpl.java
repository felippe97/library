package org.library.media.repositoryimpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.library.media.domain.Library;
import org.library.media.domain.LibraryProperties;
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
		
		 findByCondition(null);

}
}