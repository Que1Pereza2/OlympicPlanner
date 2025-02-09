package olympic.committee.events.ServiceIMPL;

import java.util.List;
import olympic.committee.events.Model.Reservations;
import olympic.committee.events.Model.SportingEvents;
import olympic.committee.events.Model.Venues;
import olympic.committee.events.Repository.ReservationsRepository;
import olympic.committee.events.Repository.SportingEventsRepository;
import olympic.committee.events.Repository.VenuesRepository;
import olympic.committee.events.Service.ReservationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *  This is the implementation class for the ReservationsService class.
 * @author Baljeet
 */
@Service
public class ReservationsServiceIMPL implements ReservationsService{

//    We declare the repositories so we can use them.
    @Autowired
    private final ReservationsRepository repository;
    private final SportingEventsRepository sportRepository;
    private final VenuesRepository venueRepository;
    
/**
 * The constructor for the class where we instantiate the declared repositories.
 * @param repository ReservationsRepository.
 * @param sportRepository SportingEventsRepository.
 * @param venueRepository  VenuesRepository.
 */
    public ReservationsServiceIMPL(ReservationsRepository repository, SportingEventsRepository sportRepository, VenuesRepository venueRepository){
        this.repository = repository;
        this.sportRepository = sportRepository;
        this.venueRepository = venueRepository;
    }
    
    /**
     * The method that creates a new reservation.
     * @param eventId - The ID of the event .
     * @param venueId - The ID of the venue.
     * @param reservationToCreate - The reservation that will be inserted in the database.
     * @return The created reservation.
     */
    @Override
    public Reservations createReservation(Long eventId, Long venueId, Reservations reservationToCreate){
        
        SportingEvents event = sportRepository.findById(eventId).get();
        Venues venue = venueRepository.findById(venueId).get();
        reservationToCreate.setEvent(event);
        reservationToCreate.setVenue(venue);
        
        return repository.save(reservationToCreate);
    }

    /**
     * This method deletes all the reservations made to a specific venue.
     * @param venueId - The id of the venue that needs it's reservations deleted.
     * @return a string indication success.
     */
    @Override
    public String deleteReservationByVenue(Long venueId) {
        List<Reservations> reservations = repository.findAll();
        
        int size = reservations.size();
        System.out.println(size);
        
        for(int i=0; i < size; i++)
            if(reservations.get(i).getVenue().equals(venueRepository.findById(venueId).get())){
                deleteReservation(reservations.get(i).getId());
                repository.delete(reservations.get(i));
            }
        
        return "Objects deleted successfully!";
    }

    /**
     * This method deletes a reservation.
     * @param id - ID of the reservation that has to be deleted.
     * @return a String if the reservation has been deleted successfully.
     */
    @Override
    public String deleteReservation(Long id) {
        Reservations reservationToDelete = repository.findById(id).get();
        reservationToDelete.getEvent().removeReservation();
        reservationToDelete.getVenue().removeReservation(id);
        repository.delete(repository.findById(id).get());
        
        return "Object deleted successfully";
    }
    
}
