package olympic.committee.events.ServiceIMPL;

import java.util.List;
import olympic.committee.events.Model.Reservations;
import olympic.committee.events.Model.SportingEvents;
import olympic.committee.events.Model.Users;
import olympic.committee.events.Repository.ReservationsRepository;
import olympic.committee.events.Repository.SportingEventsRepository;
import olympic.committee.events.Repository.UsersRepository;
import olympic.committee.events.Service.SportingEventsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *This is the implementation class for the SportingEventsService class.
 * @author Baljeet
 */
@Service
public class SportingEventsServiceIMPL implements  SportingEventsService{

//    We declare the repositories so we can use them.
    @Autowired
    private final SportingEventsRepository repository;
    private final UsersRepository userRepository;
    private final ReservationsRepository  reservationRepository;

    /**
     * The constructor for the class where we instantiate the declared repositories.
     * @param repository SportingEventsRepository.
     * @param userRepository UsersRepository.
     * @param reservationRepository ReservationsRepository.
     */
    public SportingEventsServiceIMPL(SportingEventsRepository repository, UsersRepository userRepository, ReservationsRepository reservationRepository) {
        this.repository = repository;
        this.userRepository = userRepository;
        this.reservationRepository = reservationRepository;
    }
    
    /**
     * This method creates a sporting event.
     * @param sportingEventToCreate - The sporting event that needs creation.
     * @return The created sporting event.
     */
    @Override
    public SportingEvents createSportingEvent(SportingEvents sportingEventToCreate) {
        return repository.save(sportingEventToCreate);   
    }

    /**
     * This method retrieves from the database a sporting event
     * @param id - The id of the sporting event that will be pulled from the database.
     * @return the retrieved sporting event.
     */
    @Override
    public SportingEvents getSportingEvent(Long id) {
        return repository.findById(id).get();
    }

    /**
     * This method retrieves all the sporting events from the database.
     * @return a list of all the sporting events in the database.
     */
    @Override
    public List<SportingEvents> getAllSportingEvent() {
        return repository.findAll();
    }

    /**
     * This method updates a sporting event.
     * @param idEvent - ID of the sporting event that has to be updated
     * @param sportingEventToUpdate - Information that has to be updated in the sporting event.
     * @return the updated sporting event.
     */
    @Override
    public SportingEvents updateSportingEvent(Long idEvent, SportingEvents sportingEventToUpdate) {
        sportingEventToUpdate.setId(idEvent);
        return repository.save(sportingEventToUpdate);
    }

    /**
     * This method deletes a sporting event.
     * @param id - The id of the sporting event that needs to be deleted.
     * @return the deleted sporting event.
     */
    @Override
    public SportingEvents deleteSportingEvent(Long id) {
        SportingEvents event = repository.findById(id).get();
        Reservations reservation = reservationRepository.findById(event.getReservation().getId()).get();
        List<Users> users= event.getUsers();

        for (Users user : event.getUsers()) {
            user.getEvents().remove(event);
        }
        users.clear();
        
        reservation.setEvent(null);
        reservation.getVenue().removeReservation(reservation.getId());
        reservation.setVenue(null);
        reservationRepository.delete(reservation);

        
         repository.delete(event);
         repository.flush();

         return  event;
    }

    /**
     * This method add users to an sporting event
     * @param idUser - ID of the user that has to be added.
     * @param idEvent - ID of the event where the user will be added.
     * @return the updated sporting event.
     */
    @Override
    public SportingEvents AddParticipantsToSportingEvent(Long idUser, Long idEvent) {
        Users participant = userRepository.findById(idUser).get();
        SportingEvents event =repository.findById(idEvent).get();
        event.getUsers().add(participant);
        participant.getEvents().add(event);
        repository.save(event);
        return  event;
    }
}
