package uk.co.luciditysoftware.campervibe.site.controllers;

import java.util.UUID;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import uk.co.luciditysoftware.campervibe.site.viewmodels.booking.IndexViewModelRow;
import uk.co.luciditysoftware.campervibe.site.viewmodels.booking.PendingForVehicleViewModelRow;

//http://stackoverflow.com/questions/7462202/spring-json-request-getting-406-not-acceptable

@RestController
public class BookingRestController {
	
	@RequestMapping("/testrest")
	@Transactional
    public PendingForVehicleViewModelRow testrest() {
		PendingForVehicleViewModelRow viewModel = new PendingForVehicleViewModelRow() {{
			setBookingNumber("TEST1234");
			setCustomerName("Paul");
		}};
        return viewModel;
    }
}
