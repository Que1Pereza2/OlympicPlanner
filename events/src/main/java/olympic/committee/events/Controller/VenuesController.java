/*
 * 
 * 
 * 
 */
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
 *
 * @author Baljeet
 */
@RestController
public class VenuesController {
    
    @Autowired
    private VenuesServiceIMPL repository;
    
    @PostMapping("/Create/Venue")
    public Venues createUser(@RequestBody Venues newVenue){
        return repository.createVenue(newVenue);
    }

    @GetMapping("/Read/Venues")
    public List<Venues> getAllVenues(){
        return repository.getAllVenues();
    }
    
    @DeleteMapping("/Delete/Venue/{idVenueToDelete}")
    public Venues deleteVenue(@PathVariable Long idVenueToDelete){
        return repository.deleteVenue(idVenueToDelete);
    }
}
