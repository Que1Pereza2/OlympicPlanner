/*
 * 
 * 
 * 
 */
package olympic.committee.events.Service;

import olympic.committee.events.Model.Reservations;

/**
 *
 * @author Baljeet
 */
public interface ReservationsService {
    public Reservations createReservation(Long eventId, Long venueId, Reservations reservationToCreate);
    public String deleteReservationByVenue(Long venueId);
    public String deleteReservation(Long id);
}
