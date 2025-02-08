/*
 * 
 * 
 * 
 */
package olympic.committee.events.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import java.util.List;

/**
 *
 * @author Baljeet
 */

@Entity
@Table(name = "Users")
public class Users {
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( name = "id")
    private Long id;
    
    @Column(nullable = false)
    private String name;
    
    @Column()
    private String email;
    
    
//    one user can go  to many sportingEvents.
    @JsonIgnoreProperties("events")
    @ManyToMany
    @JoinTable(
            name = "eventParticipants"
            ,joinColumns = @JoinColumn(name = "idUser", referencedColumnName = "id")
            ,inverseJoinColumns = @JoinColumn(name = "idEvent", referencedColumnName = "id")
    )
    private List<SportingEvents> events;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<SportingEvents> getEvents() {
        return events;
    }

    public void setEvents(List<SportingEvents> events) {
        this.events = events;
    }

    public void removeEvent(SportingEvents event){
        this.events.remove(event);
    }
    
}
