/*
 * 
 * 
 * 
 */
package olympic.committee.events.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
import java.sql.Time;
import java.sql.Date;

/**
 *
 * @author Baljeet
 */

@Entity
@Table(name = "Reservations")
public class Reservations {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( name = "id")
    private Long id;
    
    @Column(nullable = false)
    private Date date;
    
    @Column(nullable = false)
    private Time HourInterval;
    
    @JsonIgnoreProperties("reservation")
    @OneToOne()
    @JoinColumn(name = "idEvent", referencedColumnName = "id")
    private SportingEvents event;
//    one event has one reservation.
    
    @JsonIgnoreProperties("reservations")
    @ManyToOne()
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
