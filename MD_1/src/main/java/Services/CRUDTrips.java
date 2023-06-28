package Services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lv.venta.models.BusCategory;
import lv.venta.models.Trip;

public interface CRUDTrips {
	

			//retrieve one by id
	List<Trip> selectAlTripsByCityTitle(String Title) throws Exception;
			
			//retrieve one by title
	List<Trip> selectAlTripsByDriverId(int id) throws Exception;
			
			//create (insert)
			List<Trip> selectAlTripsToday(Date date) throws Exception;
			
			//update
			Trip changeTripDriverByDriverId(int idd, String Name,String Surname,BusCategory busType) throws Exception;
			
		
}
