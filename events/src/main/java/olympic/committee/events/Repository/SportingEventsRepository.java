/*
 * 
 * 
 * 
 */
package olympic.committee.events.Repository;

import olympic.committee.events.Model.SportingEvents;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Baljeet
 */
@Repository
public interface SportingEventsRepository extends  JpaRepository<SportingEvents, Long>{
    
}
