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
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.sql.Date;
import java.sql.Time;
import java.util.List;

/**
 *
 * @author Baljeet
 */

@Entity
@Table(name = "SportingEvents")
public class SportingEvents {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( name = "id")
    private Long id;
    
    @Column(nullable = false)
    private String name;
    
    @Column()
    private String description;
    
    @Column(nullable = false)
    private Date date;
    
    @Column(nullable = false)
    private Time eventTime;
    
    @Column(nullable = false)
    private Long duration;
    
    @ManyToMany( mappedBy = "events")
    private List<Users> users;
//    One event has many participants.
    
    @JsonIgnoreProperties("reservation")
    @OneToOne(mappedBy = "event")
    private Reservations reservation;
    
    public SportingEvents(){}
    
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getEventTime() {
        return eventTime;
    }

    public void setEventTime(Time eventTime) {
        this.eventTime = eventTime;
    }

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    public List<Users> getUsers() {
        return users;
    }

    public void setUsers(List<Users> users) {
        this.users = users;
    }

    public Reservations getReservation() {
        return reservation;
    }

    public void setReservation(Reservations reservation) {
        this.reservation = reservation;
    }
    
    public void removeReservation(){
        this.reservation= null;
    }
    
    public void removeUser(Users user){
        this.users.remove(user);
    }
}
