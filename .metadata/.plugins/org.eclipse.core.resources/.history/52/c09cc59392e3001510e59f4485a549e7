package uk.co.luciditysoftware.campervibe.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import uk.co.luciditysoftware.campervibe.domain.entities.Booking;

import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BookingController {
	
	@ResponseBody
    @RequestMapping(value = "/booking", method = RequestMethod.GET)
    public String index(Map<String, Object> model)
    {
	    ArrayList<Booking> bookings = new ArrayList<>();
	    Booking booking1 = new Booking();
	    booking1.setStartDate(new Date(2015, 10, 01));
	    booking1.setEndDate(new Date(2015, 10, 05));
	    booking1.setBookingNumber("ABD123");
	    bookings.add(booking1);
        model.put("viewModel", bookings);
        return "home/dashboard";
    }
}
