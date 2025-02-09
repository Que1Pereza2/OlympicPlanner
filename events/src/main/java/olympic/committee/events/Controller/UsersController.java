package olympic.committee.events.Controller;

import java.util.List;
import olympic.committee.events.Model.Users;
import olympic.committee.events.ServiceIMPL.UsersServiceIMPL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *  This is the controller for the Users class.
 * @author Baljeet
 */
@RestController
public class UsersController {
//    We instantiate the repository.
    @Autowired
    private UsersServiceIMPL repository;
    
    /**
     * This method creates a new user.
     * @param newUser - The new user to be inserted in the database.
     * @return The created user.
     */
    @PostMapping("/Create/User")
    public Users createUser(@RequestBody Users newUser){
        return repository.createUser(newUser);
    }
    
    /**
     * This method retrieves all the users from the database.
     * @return A list of all the users in the database.
     */
    @GetMapping("/Read/Users")
    public List<Users> getAllUsers(){
        return  repository.getAllUsers();
    }
    
    /**
     * This method updates a specific user.
     * @param idUserToUpdate - ID of the user to be updated.
     * @param updatedUser - User information to be updated.
     * @return The updated user.
     */
    @PutMapping("/Update/User/{idUserToUpdate}")
    public Users updateUser(@PathVariable Long idUserToUpdate, @RequestBody Users updatedUser){
        System.out.println(idUserToUpdate);
        System.out.println(updatedUser);
        return repository.updateUser(idUserToUpdate, updatedUser);
    }
 
    /**
     * This method deletes a user from the database.
     * @param idUserToDelete - The ID of the user that has to be deleted.
     * @return The user that has been deleted.
     */
    @DeleteMapping("/Delete/User/{idUserToDelete}")
    public Users deleteUser(@PathVariable Long idUserToDelete){
        return repository.deleteUser(idUserToDelete);
    }
}
