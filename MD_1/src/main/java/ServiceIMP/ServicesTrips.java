package ServiceIMP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import Services.CRUDDrivers;
import Services.CRUDTrips;
import lv.venta.models.BusCategory;
import lv.venta.models.City;
import lv.venta.models.Trip;
import lv.venta.models.driver;
import lv.venta.Md1Application;

public class ServicesTrips implements CRUDTrips {

    private ArrayList<driver> alldrivers;
    private ArrayList<City> allCity;

    public ServicesTrips(ArrayList<driver> alldrivers) {
        this.alldrivers = alldrivers;
        this.allCity = new ArrayList<>();
        City cit1 = new City("Riga", "AutoOSta15");
        City cit2 = new City("Frank", "Sinatra");
        
        allCity.add(cit2);
        allCity.add(cit1);
    	
		driver dri1 = new driver("Dave","Capone", BusCategory.largebus);
		driver dri2 = new driver("Frank","Sinatra", BusCategory.shcoolbus);
		alldrivers.add(dri2);
		alldrivers.add(dri1);
    }

    private ArrayList<Trip> allTrips = new ArrayList<>(Arrays.asList(
        new Trip(null, 150, alldrivers.get(0), allCity),
        new Trip(null, 150, alldrivers.get(1), allCity),
        new Trip(null, 150, alldrivers.get(2), allCity)
    ));

  
    public List<Trip> selectAlTripsByCityTitle(String Title) throws Exception {
        List<Trip> matchingTrips = new ArrayList<>();
        
        for (Trip temp : allTrips) {
            if (temp.getCities().equals(Title)) {
                matchingTrips.add(temp);
            }
        }
        
        if (matchingTrips.isEmpty()) {
            throw new Exception("No trips found");
        }
        
        return matchingTrips;
    }

    public List<Trip> selectAlTripsByDriverId(int idd) throws Exception {
        List<Trip> matchingTrips = new ArrayList<>();
        
        for (Trip temp : allTrips) {
            if (temp.getDriver().getIdd() == idd) {
                matchingTrips.add(temp);
            }
        }
        
        if (matchingTrips.isEmpty()) {
            throw new Exception("No trips found");
        }
        
        return matchingTrips;
    }

	
	 public List<Trip> selectAlTripsToday(Date date) throws Exception {
	        List<Trip> matchingTrips = new ArrayList<>();
	        
	        for (Trip temp : allTrips) {
	            if (temp.getDate().equals(date)) {
	                matchingTrips.add(temp);
	            }
	        }
	        
	        if (matchingTrips.isEmpty()) {
	            throw new Exception("No trips found");
	        }
	        
	        return matchingTrips;
	    }
	
	@Override
	public Trip changeTripDriverByDriverId(int idd, String Name, String Surname, BusCategory busType) throws Exception {
		 for (Trip temp : allTrips) {
	            if (temp.getDriver().getIdd() == idd) {
	                temp.setDriver( new driver(Name,Surname, busType));
	            }
	        }
	        throw new Exception("Wrong id");
	    }
	}


