package olympic.committee.events.ServiceIMPL;

import java.util.List;
import olympic.committee.events.Model.Venues;
import olympic.committee.events.Repository.VenuesRepository;
import olympic.committee.events.Service.VenuesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *This is the implementation class for the SportingEventsService class.
 * @author Baljeet
 */
@Service
public class VenuesServiceIMPL implements VenuesService{
    
    //    We declare the repositories so we can use them.
    @Autowired
    private final VenuesRepository repository;

    /**
     * The constructor for the class where we instantiate the declared repositories.
     * @param repository - VenuesRepository.
     */
    public VenuesServiceIMPL(VenuesRepository repository) {
        this.repository = repository;
    }
    
    /**
     * This method creates a new venue.
     * @param venueToCreate - Information of the new venue.
     * @return the created venue.
     */
    @Override
    public Venues createVenue(Venues venueToCreate) {
        return repository.save(venueToCreate);
    }

    /**
     * This method retrieves a venue from the database.
     * @param id - The id of the venue that needs to be retrieved.
     * @return the venue pulled from the database.
     */
    @Override
    public Venues getVenue(Long id) {
        return repository.findById(id).get();
    }

    /**
     * This method pulls all the venues from the database.
     * @return a list of all the venues in the database.
     */
    @Override
    public List<Venues> getAllVenues() {
        return repository.findAll();
    }

    /**
     * This method deletes a venue.
     * @param id - ID of the venue to be deleted.
     * @return the deleted venue.
     */
    @Override
    public Venues deleteVenue(Long id) {
        Venues venue = repository.findById(id).get();
        venue.getReservations().forEach(v ->{
            v.setVenue(null);
        });
        repository.delete(venue);
        return venue;
    }
}
