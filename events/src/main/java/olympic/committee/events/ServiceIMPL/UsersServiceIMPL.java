/*
 * 
 * 
 * 
 */
package olympic.committee.events.ServiceIMPL;

import java.util.List;
import olympic.committee.events.Model.Users;
import olympic.committee.events.Repository.UsersRepository;
import olympic.committee.events.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Baljeet
 */
@Service
public class UsersServiceIMPL implements  UserService{

    @Autowired
    private final UsersRepository repository;
    
    public UsersServiceIMPL(UsersRepository repository) {
        this.repository = repository;
    }

    
    @Override
    public Users createUser(Users userToCreate) {
        return repository.save(userToCreate);
    }

    @Override
    public Users getUser(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public List<Users> getAllUsers() {
        return repository.findAll();
    }

    @Override
    public Users updateUser(Long idUserToUpdate, Users userToUpdate) {
        userToUpdate.setId(idUserToUpdate);
        return repository.save(userToUpdate);
    }

    @Override
    public Users deleteUser(Long id) {
        Users userToDelete = repository.findById(id).get();
        userToDelete.getEvents().forEach( event ->{
            if(event.getUsers().contains(userToDelete))
                event.removeUser(userToDelete);
        });
        
        repository.delete(repository.findById(id).get());
        return userToDelete;
    }
    
}
