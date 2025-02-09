/*
 * 
 * 
 * 
 */
package olympic.committee.events.Service;

import java.util.List;
import olympic.committee.events.Model.SportingEvents;

/**
 *  The Service interface for SportingEvents.
 * @author Baljeet
 */
public interface SportingEventsService {
    
    public SportingEvents createSportingEvent(SportingEvents sportingEventToCreate);
    public SportingEvents getSportingEvent(Long id);
    public List<SportingEvents>getAllSportingEvent();
    public SportingEvents updateSportingEvent(Long idEvent, SportingEvents sportingEventToUpdate);
    public SportingEvents deleteSportingEvent(Long id);
    public SportingEvents AddParticipantsToSportingEvent(Long idUser, Long idEvent);
}
