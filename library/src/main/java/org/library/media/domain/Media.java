package org.library.media.domain;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

/**
 * Entity representing Media.
 * <p>
 * This class is responsible for the domain object related business logic for Media. Properties and associations are implemented in
 * the generated base class {@link org.library.media.domain.MediaBase}.
 */

@Entity
@Table(name = "MEDIA")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Media extends MediaBase {

	private static final long serialVersionUID = 1L;

	protected Media() {
	}

	public Media(String title) {
		super(title);
	}

}
