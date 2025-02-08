/*
 * 
 * 
 * 
 */
package olympic.committee.events.ServiceIMPL;

import java.util.ArrayList;
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
 *
 * @author Baljeet
 */
@Service
public class ReservationsServiceIMPL implements ReservationsService{

    @Autowired
    private final ReservationsRepository repository;
    private final SportingEventsRepository sportRepository;
    private final VenuesRepository venueRepository;
    
    public ReservationsServiceIMPL(ReservationsRepository repository, SportingEventsRepository sportRepository, VenuesRepository venueRepository){
        this.repository = repository;
        this.sportRepository = sportRepository;
        this.venueRepository = venueRepository;
    }
    
    @Override
    public Reservations createReservation(Long eventId, Long venueId, Reservations reservationToCreate){
        
        SportingEvents event = sportRepository.findById(eventId).get();
        Venues venue = venueRepository.findById(venueId).get();
        reservationToCreate.setEvent(event);
        reservationToCreate.setVenue(venue);
        
//        reservationToCreate.setEvent(sportRepository.findById(reservationToCreate.getEvent()).get());
        return repository.save(reservationToCreate);
//        return null;
    }

    @Override
    public String deleteReservationByVenue(Long venueId) {
        List<Reservations> reservations = repository.findAll();
        
        
        int size = reservations.size();
        System.out.println(size);
        
        for(int i=0; i < size; i++)
            if(reservations.get(i).getVenue().equals(venueRepository.findById(venueId).get())){
                System.out.println("getsHere");
                deleteReservation(reservations.get(i).getId());
//                reservationsToDelete.add(reservations.get(i));
//                repository.deleteById(reservations.get(i).getId());
                repository.delete(reservations.get(i));
//                repository.flush();
                System.out.println("flushes");
            }
        
        return "Objects deleted successfully!";
    }

    @Override
    public String deleteReservation(Long id) {
        Reservations reservationToDelete = repository.findById(id).get();
//        Reservations reservationToReturn = new Reservations();
        reservationToDelete.getEvent().removeReservation();
        reservationToDelete.getVenue().removeReservation(id);
        repository.delete(repository.findById(id).get());
        
        return "Object deleted successfully";
    }
    
}
