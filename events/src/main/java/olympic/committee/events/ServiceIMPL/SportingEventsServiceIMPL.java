/*
 * 
 * 
 * 
 */
package olympic.committee.events.ServiceIMPL;

import java.util.List;
import olympic.committee.events.Model.SportingEvents;
import olympic.committee.events.Model.Users;
import olympic.committee.events.Repository.ReservationsRepository;
import olympic.committee.events.Repository.SportingEventsRepository;
import olympic.committee.events.Repository.UsersRepository;
import olympic.committee.events.Service.SportingEventsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Baljeet
 */
@Service
public class SportingEventsServiceIMPL implements  SportingEventsService{

    @Autowired
    private final SportingEventsRepository repository;
    private final UsersRepository userRepository;
    private final ReservationsRepository  reservationRepository;

    public SportingEventsServiceIMPL(SportingEventsRepository repository, UsersRepository userRepository, ReservationsRepository reservationRepository) {
        this.repository = repository;
        this.userRepository = userRepository;
        this.reservationRepository = reservationRepository;
    }
    
    @Override
    public SportingEvents createSportingEvent(SportingEvents sportingEventToCreate) {
        return repository.save(sportingEventToCreate);   
    }

    @Override
    public SportingEvents getSportingEvent(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public List<SportingEvents> getAllSportingEvent() {
        return repository.findAll();
    }

    @Override
    public SportingEvents updateSportingEvent(SportingEvents sportingEventToUpdate) {
        return repository.save(sportingEventToUpdate);
    }

    @Override
    public SportingEvents deleteSportingEvent(Long id) {
        SportingEvents event = repository.findById(id).get();
        List<Users> users= event.getUsers();
        
        for(int i = 0 ; i < users.size() ; i++){
            if(users.get(i).getEvents().contains(event))
                users.get(i).getEvents().remove(event);
            
        }
        
//        users.forEach(user ->{
//            user.removeEvent(event);
//            System.out.println("It gets in");
//        });
        
        event.getUsers().clear();
        
        
//        reservationRepository.delete(event.getReservation());
//        event.removeReservation();
//        
        repository.flush();
         repository.delete(event);
//        
         return  event;
    }

    @Override
    public SportingEvents AddParticipantsToSportingEvent(Long idUser, Long idEvent) {
        Users participant = userRepository.findById(idUser).get();
        SportingEvents event =repository.findById(idEvent).get();
        event.getUsers().add(participant);
        repository.save(event);
        return  event;
    }
}
