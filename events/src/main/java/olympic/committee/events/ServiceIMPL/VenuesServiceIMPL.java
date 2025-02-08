/*
 * 
 * 
 * 
 */
package olympic.committee.events.ServiceIMPL;

import java.util.List;
import olympic.committee.events.Model.Venues;
import olympic.committee.events.Repository.VenuesRepository;
import olympic.committee.events.Service.VenuesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Baljeet
 */
@Service
public class VenuesServiceIMPL implements VenuesService{

    @Autowired
    private final VenuesRepository repository;

    public VenuesServiceIMPL(VenuesRepository repository) {
        this.repository = repository;
    }
    
    @Override
    public Venues createVenue(Venues venueToCreate) {
        return repository.save(venueToCreate);
    }

    @Override
    public Venues getVenue(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public List<Venues> getAllVenues() {
        return repository.findAll();
    }

    @Override
    public Venues deleteVenue(Long id) {
        Venues venue = repository.findById(id).get();
        repository.delete(venue);
        return venue;
    }
    
}
