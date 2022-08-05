package org.library.media.repositoryimpl;

import java.util.List;
import java.util.Map;
import java.util.Set;
import org.library.media.domain.Media;
import org.library.media.domain.MediaCharacter;
import org.library.media.domain.MediaProperties;
import org.library.media.domain.Movie;
import org.library.media.domain.MovieProperties;
import org.library.person.domain.Person;
import org.library.person.domain.PersonProperties;
import org.sculptor.framework.accessapi.ConditionalCriteria;
import org.sculptor.framework.accessapi.ConditionalCriteriaBuilder;
import org.springframework.stereotype.Repository;

/**
 * Repository implementation for Media
 */
@Repository("mediaRepository")
public class MediaRepositoryImpl extends MediaRepositoryBase {

	public MediaRepositoryImpl() {
	}

	public List<Media> findMediaByCharacter(Long libraryId, String characterName) {
		List<ConditionalCriteria> criteria = ConditionalCriteriaBuilder.criteriaFor(Media.class)
				.withProperty(MediaProperties.mediaCharacters()).eq(characterName)
				.build();

		return findByCondition(criteria);
	}

	@Override
	public List<Media> findMediaByName(Long libraryId, String name) {
		List<ConditionalCriteria> criteria = ConditionalCriteriaBuilder.criteriaFor(Media.class)
				.withProperty(MediaProperties.mediaCharacters()).eq( name)
				.build();
		return findByCondition(criteria);
	}

	@Override
	public Map<String, Movie> findMovieByUrlIMDB(Set<String> keys) {
		Map<ConditionalCriteria> criteria = ConditionalCriteriaBuilder.criteriaFor(Movie.class)
				.withProperty(MovieProperties.urlIMDB()).eq( keys)
				.build();
		return  findByCondition(criteria);
	}
}
