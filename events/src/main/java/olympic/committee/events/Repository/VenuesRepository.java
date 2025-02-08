/*
 * 
 * 
 * 
 */
package olympic.committee.events.Repository;

import olympic.committee.events.Model.Venues;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Baljeet
 */
@Repository
public interface VenuesRepository extends  JpaRepository<Venues, Long>{
    
}
