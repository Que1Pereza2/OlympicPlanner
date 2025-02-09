/*
 * 
 * 
 * 
 */
package olympic.committee.events.Service;

import java.util.List;
import olympic.committee.events.Model.Users;


/**
 *  The Service interface for Users.
 * @author Baljeet
 */
public interface UserService {
    public Users createUser(Users userToCreate);
    public Users getUser(Long id);
    public List<Users> getAllUsers();
    public Users updateUser(Long idUserToUpdate, Users userToUpdate);
    public Users deleteUser(Long id);
}
