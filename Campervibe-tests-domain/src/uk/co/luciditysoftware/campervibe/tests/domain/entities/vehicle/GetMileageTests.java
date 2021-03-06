package uk.co.luciditysoftware.campervibe.tests.domain.entities.vehicle;

import static org.junit.Assert.*;
import org.junit.Test;

import uk.co.luciditysoftware.campervibe.domain.entities.Booking;
import uk.co.luciditysoftware.campervibe.domain.entities.Vehicle;

import java.util.*;
import java.math.*;

public class GetMileageTests {

	@Test
	public void canFindHighestMileageWhenInMidddle() {
		//Arrange.
		Vehicle vehicle = new Vehicle();
		Collection<Booking> bookings = new ArrayList<Booking>();
		
		bookings.add(new Booking() 
		{{
			setEndMileage(new BigDecimal(10000.00));
			setVehicle(vehicle);
		}});
		
		bookings.add(new Booking() 
		{{
			setEndMileage(new BigDecimal(50000.00));
			setVehicle(vehicle);
		}});
		
		bookings.add(new Booking() 
		{{
			setEndMileage(new BigDecimal(20000.00));
			setVehicle(vehicle);
		}});
		
		bookings.add(new Booking() 
		{{
			setEndMileage(new BigDecimal(40000.00));
			setVehicle(vehicle);
		}});
		
		vehicle.setBookings(bookings);
		
		//Act.
		BigDecimal mileage = vehicle.getMileage();
		
		//Assert.
		assertTrue(mileage.equals(new BigDecimal(50000.00)));
	}

	@Test
	public void returnsNullWhenNoResults() {
		//Arrange.
		Vehicle vehicle = new Vehicle();
		Collection<Booking> bookings = new ArrayList<Booking>();
		vehicle.setBookings(bookings);
		
		//Act.
		BigDecimal mileage = vehicle.getMileage();
		
		//Assert.
		assertNull(mileage);
	}
}

