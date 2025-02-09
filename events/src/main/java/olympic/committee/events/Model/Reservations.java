package olympic.committee.events.Model;

//imports
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.sql.Time;
import java.sql.Date;

/**
 *  This is the model class for Reservations.
 * @author Baljeet
 */

//Anotations needed for springboot and Hibernate to recognize the class appropiately.
@Entity
@Table(name = "Reservations")
public class Reservations {
    
//    ID of reservation.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( name = "id")
    private Long id;
    
//    Date for the reservation.
    @Column(nullable = false)
    private Date date;
    
//    How long will the reservation last.
    @Column(nullable = false)
    private Time HourInterval;
    
//    The event for which the reservation is for.
    @JsonIgnoreProperties("reservation")
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH})
    @JoinColumn(name = "idEvent", referencedColumnName = "id")
    private SportingEvents event;
    
//    The venue for which the reservation is for.
    @JsonIgnoreProperties("reservations")
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST,CascadeType.DETACH})
    @JoinColumn(name = "venue" )
    private Venues venue;
    
    public Reservations(){
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getHourInterval() {
        return HourInterval;
    }

    public void setHourInterval(Time HourInterval) {
        this.HourInterval = HourInterval;
    }

    public SportingEvents getEvent() {
        return event;
    }

    public void setEvent(SportingEvents event) {
        this.event = event;
    }

    public Venues getVenue() {
        return venue;
    }

    public void setVenue(Venues venue) {
        this.venue = venue;
    }
    
    public void removeVenue(){
        this.venue = null;
    }
}
