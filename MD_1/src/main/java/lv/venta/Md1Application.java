package lv.venta;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import lv.venta.repos.CashierRepo;
import lv.venta.repos.CityRepo;
import lv.venta.repos.DriverRepo;
import lv.venta.repos.TicketRepo;
import lv.venta.repos.TripRepo;
import lv.venta.models.Cashier;
import lv.venta.models.driver;
import lv.venta.models.City;
import lv.venta.models.BusCategory;
import lv.venta.models.Ticket;
import lv.venta.models.Trip;
import ServiceIMP.Service;

@SpringBootApplication
public class Md1Application {

	public static void main(String[] args) {
		
		SpringApplication.run(Md1Application.class, args);
		
	}
	@Bean
	public CommandLineRunner testModel(CashierRepo cRepo, CityRepo citRepo, DriverRepo dRepo, TicketRepo tRepo, TripRepo trRepo) {
		City cit1 = new City("Riga","AutoOSta15");
		City cit2 = new City("Frank","Sinatra");
		ArrayList<City> allCity = new ArrayList<>();
		allCity.add(cit2);
		allCity.add(cit1);
		return new CommandLineRunner() {

			@Override
			public void run(String... args) throws Exception {
				Cashier cas1 = new Cashier("Dana","White");
				Cashier cas2 = new Cashier("Frank","Sinatra");
				cRepo.save(cas1);
				cRepo.save(cas2);
			
				citRepo.save(cit1);
				citRepo.save(cit2);
				
				driver dri1 = new driver("Dave","Capone", BusCategory.largebus);
				driver dri2 = new driver("Frank","Sinatra", BusCategory.shcoolbus);
				dRepo.save(dri1);
				dRepo.save(dri2);
			
				Trip tri1 = new Trip( "2000-01-01",  150 , dri2,allCity);
				Trip tri2 = new Trip("2023-12-31", 400 , dri1 ,allCity);
				trRepo.save(tri1);
				trRepo.save(tri2);
				System.out.println(tri1);
				
				
			
				Ticket Tic1 = new Ticket(Date.valueOf("2015-03-31"), tri1, cas1, (float) 15.4, false);
				Ticket Tic2 = new Ticket(Date.valueOf("2017-03-31"), tri2, cas2, (float) 7.4, true);
				tRepo.save(Tic1);
				tRepo.save(Tic2);
			
				
			
			}
		};
	}
}
