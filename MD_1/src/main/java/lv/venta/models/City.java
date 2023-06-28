package lv.venta.models;

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
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "City")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class City {
	@Setter(value = AccessLevel.NONE)
	@Column(name="idc")
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
	private long idc;
	
	@Column(name = "Title")
	private String title;
	
	@Column(name = "AddressOfStation")
	private String addressOfStation;
	
	

	 @ManyToMany(mappedBy = "cities")
	    private List<Trip> trips;
	
	public City(String title, String addressOfStation) {
		super();
		this.title = title;
		this.addressOfStation = addressOfStation;

	}
	
}

