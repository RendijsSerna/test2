package lv.venta.models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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

@Table(name = "Trip table")
@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class driver  {
	
	@Setter(value = AccessLevel.NONE)
	@Column(name="Idd")
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
	private long idd;
	
	
	@Column(name = "Name")//DB puse būs kolonna title
	@NotNull
	@Pattern(regexp = "[A-ZĒŪĪĻĶŠĀŽČŅ]{1}[a-zēūīļķšāžčņ\\ ]+", message = "Pirmajam burtam jābūt lielajam")
	@Size(min = 3, max = 30, message = "Jabūt vismaz 3 un ne vairāk kā 30 simboliem")	
	private String Name;
	
	@Column(name = "Surname")//DB puse būs kolonna title
	@NotNull
	@Pattern(regexp = "[A-ZĒŪĪĻĶŠĀŽČŅ]{1}[a-zēūīļķšāžčņ\\ ]+", message = "Pirmajam burtam jābūt lielajam")
	@Size(min = 3, max = 30, message = "Jabūt vismaz 3 un ne vairāk kā 30 simboliem")
	private String Surname;
	

    @Enumerated(EnumType.STRING)
    @Column(name = "bus_type")
    private BusCategory busType;
	

   
    @OneToMany(mappedBy = "driver")
	@ToString.Exclude
	 private  List<Trip> trips;



	public driver(
			 String name, String surname,BusCategory busType) {
		super();
		Name = name;
		Surname = surname;
		this.busType = busType;
	
	}
    
	public long getIdd() {
        return idd;
    }
	
  
	
	
}
