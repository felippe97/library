package org.library.media.accessimpl;

import java.sql.PreparedStatement;
import java.util.Map;

/**
 * Implementation of Access object for MediaRepository.getNumberOfMovies.
 *
 */
public class GetNumberOfMoviesAccessImpl extends GetNumberOfMoviesAccessImplBase {

	public void performExecute() {
		 try {
			    for ( Map.Entry<String,PreparedStatement> entry : getStatements().entrySet() ) {
			      try {
			        final PreparedStatement statement = entry.getValue();
			        checkRowCounts( statement.executeBatch(), statement );
			      }
			      catch ( SQLException e ) {
			        LOG.debug( "SQLException escaped proxy", e );
			        throw sqlExceptionHelper().convert( e, "could not perform addBatch", entry.getKey() );
			      }
			    }
			  }
			  catch ( RuntimeException re ) {
			    LOG.unableToExecuteBatch( re.getMessage() );
			    throw re;
			  }
			  finally {
			    batchPosition = 0;
	}

}
}