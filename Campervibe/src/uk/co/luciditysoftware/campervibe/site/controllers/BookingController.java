package uk.co.luciditysoftware.campervibe.site.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import uk.co.luciditysoftware.campervibe.site.domain.entities.Booking;

import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BookingController {
	
	@ResponseBody
    @RequestMapping(value = "/booking/index", method = RequestMethod.GET)
    public ModelAndView index(Map<String, Object> model)
    {
	    ArrayList<Booking> bookings = new ArrayList<>();
	    Booking booking1 = new Booking();
	    booking1.setStartDate(new Date(2015, 10, 01));
	    booking1.setEndDate(new Date(2015, 10, 05));
	    booking1.setBookingNumber("ABD123");
	    bookings.add(booking1);
        model.put("viewModel", booking1);
        return new ModelAndView("booking/index");
    }
}
