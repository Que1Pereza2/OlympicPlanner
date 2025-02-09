package olympic.committee.events.Controller;

import com.fasterxml.jackson.databind.JsonNode;
import java.util.List;
import olympic.committee.events.Model.SportingEvents;
import olympic.committee.events.Service.SportingEventsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *  This is the controller for the SportingEvents.
 * @author Baljeet
 */
@RestController
public class SportingEventsController {
 //    We instantiate the repository.
    @Autowired
    SportingEventsService repository;
    
    /**
     * This method creates a new event.
     * @param newSportingEvent - The new event that needs to be inserted into the database.
     * @return The newly inserted event.
     */
    @PostMapping("/Create/Event")
    public SportingEvents createSportingEvent(@RequestBody SportingEvents newSportingEvent){
        return repository.createSportingEvent(newSportingEvent);
    }
    
    /**
     *  This method retrieves all the events from the database.
     * @return A list of all the events in the database.
     */
    @GetMapping("/Read/AllEvents")
    public List<SportingEvents> getAllEvents(){
        return repository.getAllSportingEvent();
    }
    
    /**
     * This method updates a specific event.
     * @param idEvent - ID of the event that has to be updated.
     * @param updatedEvent - The updated event.
     * @return The updated event.
     */
    @PutMapping("/Update/Event/{idEvent}")
    public SportingEvents updateEvent(@PathVariable Long idEvent, @RequestBody SportingEvents updatedEvent){
        return repository.updateSportingEvent(idEvent, updatedEvent);
    }
    
    /**
     * This method adds an user to an event as a participant.
     * @param request - a JSON that contains the ID of the event and the ID of the user
     * @return The updated event.
     */
    @PutMapping("/Update/Event/User")
    public SportingEvents addUserToEvent(@RequestBody JsonNode request){
         Long idUser = request.get("idUser").asLong();
        Long idEvent = request.get("idEvent").asLong();
        return repository.AddParticipantsToSportingEvent(idUser,idEvent);
    }
    
    /**
     * This method deletes an event from the database.
     * @param idEvent - The ID of the event to be deleted.
     * @return The deleted event.
     */
    @DeleteMapping("/Delete/Event/{idEvent}")
    public SportingEvents deleteEvent(@PathVariable Long idEvent){
        return repository.deleteSportingEvent(idEvent);
    }
}
