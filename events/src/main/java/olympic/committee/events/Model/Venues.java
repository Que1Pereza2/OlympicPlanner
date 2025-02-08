/*
 * 
 * 
 * 
 */
package olympic.committee.events.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Baljeet
 */

@Entity
@Table(name = "Venues")
public class Venues {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    
    @Column(nullable = false)
    private String name;

    @Column()
    private String venueType; // ask about this later
    
    @Column()
    private String location;

    @JsonIgnoreProperties("venues")
    @OneToMany(mappedBy = "venue", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Reservations> reservations;
//    one venue can have many reservations

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
    
    public void removeReservation(Long idReservation){
        List<Reservations> reservationsCopy = new ArrayList<>();
        reservationsCopy.addAll(this.reservations);
        
        for(Reservations reservation : reservationsCopy)
            if(reservation.getId().equals(idReservation)){
                this.reservations.remove(reservation);
                break;
            }
    }

}
