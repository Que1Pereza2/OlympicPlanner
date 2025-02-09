package olympic.committee.events.Controller;

import com.fasterxml.jackson.databind.JsonNode;
import java.sql.Date;
import java.sql.Time;
import olympic.committee.events.Model.Reservations;
import olympic.committee.events.ServiceIMPL.ReservationsServiceIMPL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *  This is the controller for the Reservations class.
 * @author Baljeet
 */
@RestController
public class ReservationsController {

//    We instantiate the repository.
    @Autowired
    private ReservationsServiceIMPL repository;
    
    /**
     * This method creates a new reservation.
     * @param reservationJSON - A JSON that contains the ID of the event and the ID of the venue.
     * @return The created reservation.
     */
    @PostMapping("/Create/Reservation")
    public Reservations createReservation(@RequestBody JsonNode reservationJSON){
        Long eventId = reservationJSON.get("eventId").asLong();
        Long venueId = reservationJSON.get("venueId").asLong();
        
        Reservations newReservation = new Reservations();
        newReservation.setDate(Date.valueOf(reservationJSON.get("date").asText()));
        newReservation.setHourInterval((Time.valueOf(reservationJSON.get("hourInterval").asText())));
        return repository.createReservation(eventId , venueId, newReservation);
    }
    
    /**
     * This method deletes a reservation from the database based on the venue.
     * @param idVenue - ID of the venue whose reservations have to be deleted.
     * @return A success message if the deletion was correct.
     */
    @DeleteMapping("/Delete/Reservation/Venue/{idVenue}")
    public String deleteReservationBasedOnVenue(@PathVariable Long idVenue){
        System.out.println("gets to controller");
        return repository.deleteReservationByVenue(idVenue);
    }

    /**
     * This method deletes a reservation.
     * @param reservationToDelete - The ID of the reservation that has to be deleted.
     * @return The deleted reservation.
     */
    @DeleteMapping("/Delete/Reservation/{reservationToDelete}")
    public String deleteReservation(@PathVariable Long reservationToDelete){
        return repository.deleteReservation(reservationToDelete);
    }    
}
