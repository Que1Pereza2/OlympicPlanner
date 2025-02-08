/*
 * 
 * 
 * 
 */
package olympic.committee.events.Repository;

import olympic.committee.events.Model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Baljeet
 */
@Repository
public interface UsersRepository extends JpaRepository<Users, Long>{
    
}
