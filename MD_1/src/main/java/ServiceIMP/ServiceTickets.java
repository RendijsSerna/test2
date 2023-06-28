package ServiceIMP;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import lv.venta.models.BusCategory;
import lv.venta.models.Cashier;
import lv.venta.models.City;
import lv.venta.models.Ticket;
import lv.venta.models.Trip;
import lv.venta.models.driver;
import lv.venta.repos.CashierRepo;
import lv.venta.repos.CityRepo;
import lv.venta.repos.DriverRepo;
import lv.venta.repos.TicketRepo;
import lv.venta.repos.TripRepo;
import Services.CRUDTicket;

public abstract class ServiceTickets implements CRUDTicket {

    private TripRepo tripRepo; // Assuming you have a TripRepo instance for accessing Trip data
    private TicketRepo tRepo;
    private DriverRepo dRepo;

    public ServiceTickets(CashierRepo cRepo, CityRepo citRepo, DriverRepo dRepo, TicketRepo tRepo, TripRepo trRepo) {
      this.tRepo = tRepo;
    }

    public List<Ticket> selectAllChildTickets() throws Exception {
        List<Ticket> matchingBool = new ArrayList<>();

        Iterable<Ticket> allTickets = tRepo.findAll(); 

        for (Ticket temp : allTickets) {
            if (temp.getIsChild().equals(true)) {
                matchingBool.add(temp);
            }
        }

        if (matchingBool.isEmpty()) {
            throw new Exception("No Child found");
        }

        return matchingBool;
    } 
    public List<Ticket> selectAllTicketsWherePriceIsLow(Float Price) throws Exception {
        List<Ticket> matchingBool = new ArrayList<>();

        Iterable<Ticket> allTickets = tRepo.findAll(); 

        for (Ticket temp : allTickets) {
            if (temp.getPrice() ==(Price)) {
                matchingBool.add(temp);
            }
        }

        if (matchingBool.isEmpty()) {
            throw new Exception("No Price found");
        }

        return matchingBool;
    }
    public List<Ticket> selectAllTicketsByTripId(int idtr) throws Exception {
        List<Ticket> matchingIdTr = new ArrayList<>();

        Iterable<Ticket> allTickets = tRepo.findAll(); 

        for (Ticket temp : allTickets) {
            if (temp.getTrip().returnidtr() ==(idtr)) {
            	matchingIdTr.add(temp);
            }
        }

        if (matchingIdTr.isEmpty()) {
            throw new Exception("No IdTr found");
        }

        return matchingIdTr;
    }
    public float calculateIncomeOfTripByTripId(int idtr) throws Exception {
       float sum =0;

        Iterable<Ticket> allTickets = tRepo.findAll(); 

        for (Ticket temp : allTickets) {
            if (temp.getTrip().returnidtr() ==(idtr)) {
            	sum = sum+ temp.getPrice();  
            }
            
            
        }

       
        

        return sum;
    }
    public float calculateIncomeOfCashierByCashierId(int idca) throws Exception {
    	float sum = 0;
        Iterable<Ticket> allTickets = tRepo.findAll(); 

        for (Ticket temp : allTickets) {
            if (temp.getCashier().returnIdc() ==(idca)) {
            	sum = sum+ temp.getPrice();
            
            }
        }

       
        return sum;
    }
    public Ticket insertNewTicketByTripId(int idtr,Date purchaseDate, Trip trip, Cashier cashier, Float price, Boolean isChild) throws Exception {
    	Ticket test = null;
        Iterable<Ticket> allTickets = tRepo.findAll(); 
        
		 for (Ticket temp : allTickets) {
	            if (temp.getTrip().returnidtr() == idtr) {
	                test.setPurchaseDate((java.sql.Date) purchaseDate);
	                test.setTrip(trip);
	                test.setCashier(cashier);
	                test.setPrice(price);
	                test.setIsChild(isChild);
	                
	            }
	        }
	        
	        return test;
	    }
    
    
    
	
}
