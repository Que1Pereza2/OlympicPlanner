package olympic.committee.events.Controller;

import java.util.List;
import olympic.committee.events.Model.Venues;
import olympic.committee.events.ServiceIMPL.VenuesServiceIMPL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *  The controller for the Venues class.
 * @author Baljeet
 */

@RestController
public class VenuesController {
    
//    We instantiate the repository.
    @Autowired
    private VenuesServiceIMPL repository;
    /**
     *  This method creates a new venue
     * @param newVenue - the new venue that will be inserted in the database.
     * @return The inserted venue.
     */
    @PostMapping("/Create/Venue/")
    public Venues createUser(@RequestBody Venues newVenue){
        return repository.createVenue(newVenue);
    }

    /**
     * This method retrieves all venues from the database.
     * @return A list of all the venues in the database.
     */
    @GetMapping("/Read/Venues")
    public List<Venues> getAllVenues(){
        return repository.getAllVenues();
    }
    
    /**
     * This method deletes a venue from the database.
     * @param idVenueToDelete - the ID of the venue that has to be deleted.
     * @return The deleted venue.
     */
    @DeleteMapping("/Delete/Venue/{idVenueToDelete}")
    public Venues deleteVenue(@PathVariable Long idVenueToDelete){
        return repository.deleteVenue(idVenueToDelete);
    }
}
