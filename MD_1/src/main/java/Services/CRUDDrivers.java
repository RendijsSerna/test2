package Services;

import java.util.ArrayList;

import lv.venta.models.BusCategory;
import lv.venta.models.driver;

public interface CRUDDrivers {
	//CRUD  -create - retrieve - update - delete 
	
		//retrieve all
		ArrayList<driver> retrieveAlldrivers();

		//retrieve one by id
		driver retrieveOnedriverById(int idd) throws Exception;
		
		//retrieve one by title
		ArrayList<driver> retrieveAlldriversByTitle(String Name) throws Exception;
		
		//create (insert)
		driver insertdriverByParams(String Name,String Surname,BusCategory busType);
		
		//update
		driver updatedriverByParams(int idd, String Name,String Surname,BusCategory busType) throws Exception;
		
		//delete
		void deletedriverById(int idd) throws Exception;
		
		
}
