package olympic.committee.events.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;

/**
 * This is the model class for Venues.
 * @author Baljeet
 */

//Anotations needed for springboot and Hibernate to recognize the class appropiately.
@Entity
@Table(name = "Venues")
public class Venues {
    
    //    ID of reservation.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
//    The venue's name.
    @Column(nullable = false)
    private String name;

//    The type of venue this is.
    @Column()
    private String venueType;
    
//    Where the venue is located.
    @Column()
    private String location;

//    The reservations for this venue.
    @JsonIgnoreProperties("venues")
    @OneToMany(mappedBy = "venue", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Reservations> reservations;

//    Constructor
    public Venues(){
    
    }

//    Getters and Setters

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

    public String getVenueType() {
        return venueType;
    }

    public void setVenueType(String venueType) {
        this.venueType = venueType;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Reservations> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservations> reservations) {
        this.reservations = reservations;
    }
    
//    Method that removes a reservation from the list.
    public void removeReservation(Long idReservation){
        for (Reservations reservation : this.reservations) {
           if (reservation.getId().equals(idReservation)) {
               this.reservations.remove(reservation);
               break;
           }
       }
    }
}
