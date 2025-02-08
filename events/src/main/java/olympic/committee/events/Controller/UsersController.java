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
 *
 * @author Baljeet
 */
@RestController
public class UsersController {
    
    @Autowired
    private UsersServiceIMPL repository;
    
    @PostMapping("/Create/User")
    public Users createUser(@RequestBody Users newUser){
        return repository.createUser(newUser);
    }
    
    @GetMapping("/Read/Users")
    public List<Users> getAllUsers(){
        return  repository.getAllUsers();
    }
    
    @PutMapping("/Update/User/{idUserToUpdate}")
    public Users updateUser(@PathVariable Long idUserToUpdate, @RequestBody Users updatedUser){
        System.out.println(idUserToUpdate);
        System.out.println(updatedUser);
        return repository.updateUser(idUserToUpdate, updatedUser);
    }
 
    @DeleteMapping("/Delete/User/{idUserToDelete}")
    public Users deleteUser(@PathVariable Long idUserToDelete){
        return repository.deleteUser(idUserToDelete);
    }
}
