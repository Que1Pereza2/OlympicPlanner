/*
 * 
 * 
 * 
 */
package olympic.committee.events.Repository;

import olympic.committee.events.Model.Reservations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Baljeet
 */
@Repository
public interface ReservationsRepository extends JpaRepository<Reservations, Long>{
    
}
