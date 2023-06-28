package Services;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import lv.venta.models.Cashier;
import lv.venta.models.Ticket;
import lv.venta.models.Trip;

public interface CRUDTicket extends CrudRepository<Ticket, Long> {
	List<Ticket> selectAllChildTickets() throws Exception;
	
	//retrieve one by title
	List<Ticket> selectAllTicketsWherePriceIsLow(float price) throws Exception;
	
	//create (insert)
	List<Ticket> selectAlTripsToday(Date date) throws Exception;
	
	//update
	Ticket changeTripDriverByDriverId(int idtr,Date purchaseDate, Trip trip, Cashier cashier, Float price, Boolean isChild) throws Exception;
	
}
