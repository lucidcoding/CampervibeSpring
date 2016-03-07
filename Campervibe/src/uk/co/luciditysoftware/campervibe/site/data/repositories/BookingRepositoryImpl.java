package uk.co.luciditysoftware.campervibe.site.data.repositories;

import java.util.ArrayList;
import java.util.Date;
//import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import uk.co.luciditysoftware.campervibe.site.domain.entities.Booking;
import uk.co.luciditysoftware.campervibe.site.domain.entities.Vehicle;
import uk.co.luciditysoftware.campervibe.site.domain.repositorycontracts.BookingRepository;

@Component
public class BookingRepositoryImpl implements BookingRepository {

	@Override
	public List<Booking> getAll() {
		ArrayList<Booking> bookings = new ArrayList<Booking>();
		Booking booking1 = new Booking();
	    booking1.setStartDate(new Date(2015, 10, 01));
	    booking1.setEndDate(new Date(2015, 10, 05));
	    booking1.setBookingNumber("A00001");
	    Vehicle vehicle1 = new Vehicle();
	    vehicle1.setName("Archie");
	    booking1.setVehicle(vehicle1);
	    Booking booking2 = new Booking();
	    booking2.setStartDate(new Date(2015, 10, 01));
	    booking2.setEndDate(new Date(2015, 10, 05));
	    booking2.setBookingNumber("A00002");
	    Vehicle vehicle2 = new Vehicle();
	    vehicle2.setName("Betty");
	    booking2.setVehicle(vehicle2);
	    bookings.add(booking1);
	    bookings.add(booking2);
	    return bookings;
	}
	
}
