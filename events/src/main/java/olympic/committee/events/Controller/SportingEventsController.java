/*
 * 
 * 
 * 
 */
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
 *
 * @author Baljeet
 */
@RestController
public class SportingEventsController {
 
    @Autowired
    SportingEventsService repository;
    
    @PostMapping("/Create/Event")
    public SportingEvents createSportingEvent(@RequestBody SportingEvents newSportingEvent){
        return repository.createSportingEvent(newSportingEvent);
    }
    
    @GetMapping("/Read/AllEvents")
    public List<SportingEvents> getAllEvents(){
        return repository.getAllSportingEvent();
    }
    
    @PutMapping("/Update/Event")
    public SportingEvents updateEvent(@RequestBody SportingEvents updatedEvent){
        return repository.updateSportingEvent(updatedEvent);
    }
    
    @PutMapping("/Update/Event/User")
    public SportingEvents addUserToEvent(@RequestBody JsonNode request){
         Long idUser = request.get("idUser").asLong();
        Long idEvent = request.get("idEvent").asLong();
        return repository.AddParticipantsToSportingEvent(idUser,idEvent);
    }
    
    @DeleteMapping("/Delete/Event/{idEvent}")
    public SportingEvents deleteEvent(@PathVariable Long idEvent){
        return repository.deleteSportingEvent(idEvent);
    }
    
    
}
