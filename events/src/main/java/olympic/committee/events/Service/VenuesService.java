/*
 * 
 * 
 * 
 */
package olympic.committee.events.Service;

import java.util.List;
import olympic.committee.events.Model.Venues;


/**
 *
 * @author Baljeet
 */
public interface VenuesService {
    public Venues createVenue(Venues venueToCreate);
    public Venues getVenue(Long id);
    public List<Venues> getAllVenues();
    public Venues deleteVenue(Long id);
}
