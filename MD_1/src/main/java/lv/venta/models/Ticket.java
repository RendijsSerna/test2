package lv.venta.models;

import java.sql.Date;
import java.util.Collection;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "Ticket")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Ticket {
	@Setter(value = AccessLevel.NONE)
	@Column(name="idt")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private long idt;
	
	@Column(name = "PurchaseDate")
	private Date purchaseDate;
	
	@ManyToOne
	@JoinColumn(name = "trip")
	private Trip trip;
	
	@ManyToOne
	@JoinColumn(name = "cashier")
	private Cashier cashier;
	
	@Column(name = "Price")
	private Float price;
	
	@Column(name = "IsChild")
	private Boolean isChild;

	public Ticket(Date date, Trip trip, Cashier cashier, Float price, Boolean isChild) {
		super();
		this.purchaseDate = date;
		this.trip = trip;
		this.cashier = cashier;
		this.price = price;
		this.isChild = isChild;
	}
	
}


	

