package olympic.committee.events.ServiceIMPL;

import java.util.List;
import olympic.committee.events.Model.Users;
import olympic.committee.events.Repository.UsersRepository;
import olympic.committee.events.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *This is the implementation class for the SportingEventsService class.
 * @author Baljeet
 */
@Service
public class UsersServiceIMPL implements  UserService{

    //    We declare the repositories so we can use them.
    @Autowired
    private final UsersRepository repository;
    
    /**     
     * The constructor for the class where we instantiate the declared repositories.
     * @param repository - UsersRepository.
     */
    public UsersServiceIMPL(UsersRepository repository) {
        this.repository = repository;
    }

    /**
     * This method created a user.
     * @param userToCreate - The user information.
     * @return the created user.
     */
    @Override
    public Users createUser(Users userToCreate) {
        return repository.save(userToCreate);
    }

    /**
     * This method retrieves a user.
     * @param id - ID of the user to be retrieved.
     * @return the user pulled from the database.
     */
    @Override
    public Users getUser(Long id) {
        return repository.findById(id).get();
    }

    /**
     * This method retrieves all the users from the database.
     * @return a list of all the users from the database.
     */
    @Override
    public List<Users> getAllUsers() {
        return repository.findAll();
    }

    /**
     * This method updates a user.
     * @param idUserToUpdate - ID of the user that has to be updated.
     * @param userToUpdate - The new user information.
     * @return the updated user.
     */
    @Override
    public Users updateUser(Long idUserToUpdate, Users userToUpdate) {
        userToUpdate.setId(idUserToUpdate);
        return repository.save(userToUpdate);
    }

    /**
     * This method deleted a user.
     * @param id - id of the user that has to be deleted.
     * @return the deleted user.
     */
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
