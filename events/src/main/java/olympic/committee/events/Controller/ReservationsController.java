/*
 * 
 * 
 * 
 */
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
 *
 * @author Baljeet
 */
@RestController
public class ReservationsController {
    
    @Autowired
    private ReservationsServiceIMPL repository;
    
    @PostMapping("/Create/Reservation")
    public Reservations createReservation(@RequestBody JsonNode reservationJSON){
        Long eventId = reservationJSON.get("eventId").asLong();
        Long venueId = reservationJSON.get("venueId").asLong();
        
        Reservations newReservation = new Reservations();
        newReservation.setDate(Date.valueOf(reservationJSON.get("date").asText()));
        newReservation.setHourInterval((Time.valueOf(reservationJSON.get("hourInterval").asText())));
        return repository.createReservation(eventId , venueId, newReservation);
    }
    
    @DeleteMapping("/Delete/Reservation/Venue/{idVenue}")
    public String deleteReservationBasedOnVenue(@PathVariable Long idVenue){
        System.out.println("gets to controller");
        return repository.deleteReservationByVenue(idVenue);
    }

    @DeleteMapping("/Delete/Reservation/{reservationToDelete}")
    public String deleteReservation(@PathVariable Long reservationToDelete){
        return repository.deleteReservation(reservationToDelete);
    }    
}
