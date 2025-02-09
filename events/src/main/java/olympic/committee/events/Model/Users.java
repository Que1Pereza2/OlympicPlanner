package olympic.committee.events.Model;

import jakarta.persistence.CascadeType;
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
 * This is the model class for Users.
 * @author Baljeet
 */

//Anotations needed for springboot and Hibernate to recognize the class appropiately.
@Entity
@Table(name = "Users")
public class Users {
//   The User's ID.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( name = "id")
    private Long id;
    
//    The User's name.
    @Column(nullable = false)
    private String name;
//    The user's email
    @Column()
    private String email;
    
//    Events to which the user subscribed.
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "eventParticipants"
            ,joinColumns = @JoinColumn(name = "idUser", referencedColumnName = "id")
            ,inverseJoinColumns = @JoinColumn(name = "idEvent", referencedColumnName = "id")
    )
    private List<SportingEvents> events;
    
//    Getters and Setters.
    
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
