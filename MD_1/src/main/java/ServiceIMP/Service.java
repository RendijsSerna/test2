package ServiceIMP;

import java.util.Arrays;
import java.util.ArrayList;

import Services.CRUDDrivers;
import lv.venta.models.BusCategory;
import lv.venta.models.driver;


public class Service implements CRUDDrivers {

    public ArrayList<driver> alldrivers = new ArrayList<>(Arrays.asList(
            new driver("Dave", "Capone", BusCategory.largebus),
            new driver("Frank", "Sinatra", BusCategory.shcoolbus),
            new driver("Frank", "Sinatra", BusCategory.shcoolbus)
    ));

    @Override
    public ArrayList<driver> retrieveAlldrivers() {
        return alldrivers;
    }

    @Override
    public driver retrieveOnedriverById(int idd) throws Exception {
        for (driver temp : alldrivers) {
            if (temp.getIdd() == idd) {
                return temp;
            }
        }
        throw new Exception("Wrong id");
    }

    @Override
    public ArrayList<driver> retrieveAlldriversByTitle(String Name) throws Exception {
        if (Name != null) {
            ArrayList<driver> alldriversWithName = new ArrayList<>();
            for (driver temp : alldrivers) {
                if (temp.getName().equals(Name)) {
                    alldriversWithName.add(temp);
                }
            }
            return alldriversWithName;
        } else {
            throw new Exception("Wrong Name");
        }
    }

    @Override
    public driver insertdriverByParams(String Name, String Surname, BusCategory busType) {
        driver newdriver = new driver(Name, Surname, busType);
        alldrivers.add(newdriver);
        return newdriver;
    }

    @Override
    public driver updatedriverByParams(int idd, String Name, String Surname, BusCategory busType)
            throws Exception {
        for (driver temp : alldrivers) {
            if (temp.getIdd() == idd) {
                temp.setName(Name);
                temp.setSurname(Surname);
                temp.setBusType(busType);
                return temp;
            }
        }
        throw new Exception("Wrong id");
    }

    @Override
    public void deletedriverById(int idd) throws Exception {
        boolean isFound = false;
        for (driver temp : alldrivers) {
            if (temp.getIdd() == idd) {
                alldrivers.remove(temp);
                isFound = true;
                break;
            }
        }
        if (!isFound) {
            throw new Exception("Wrong id");
        }
    }

    public static void main(String[] args) {
        // Your main method code goes here

    }

}
