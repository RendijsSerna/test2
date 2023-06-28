package lv.venta.models;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "Trip")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Trip {
    @Setter(value = AccessLevel.NONE)
    @Column(name = "idtr")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idtr;

    @Column(name = "StartTime")
    private String date;

    @Column(name = "Duration")
    private int duration;

    @OneToMany(mappedBy = "trip")
    @ToString.Exclude
    private List<Ticket> tickets;

    @ManyToOne
    @JoinColumn(name = "driver")
    private driver driver;

    @ManyToMany
    @JoinTable(
            name = "Trip_City",
            joinColumns = @JoinColumn(name = "trip_id"),
            inverseJoinColumns = @JoinColumn(name = "city_id")
    )
    private List<City> cities;

    public Trip(String date, int duration, driver driver, List<City> cities) {
        super();
        this.date = date;
        this.duration = duration;
        this.driver = driver;
        this.cities = cities;
    }
    public long returnidtr() {
    	return idtr;
    }
}
