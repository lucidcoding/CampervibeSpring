package uk.co.luciditysoftware.campervibe.site.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.context.internal.ThreadLocalSessionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import uk.co.luciditysoftware.campervibe.config.Bootstrap;
import uk.co.luciditysoftware.campervibe.domain.entities.Booking;
import uk.co.luciditysoftware.campervibe.domain.entities.Vehicle;
import uk.co.luciditysoftware.campervibe.domain.repositorycontracts.BookingRepository;
import uk.co.luciditysoftware.campervibe.domain.repositorycontracts.VehicleRepository;
import uk.co.luciditysoftware.campervibe.domain.requests.booking.MakeRequest;
import uk.co.luciditysoftware.campervibe.site.viewmodels.booking.IndexViewModel;
import uk.co.luciditysoftware.campervibe.site.viewmodels.booking.IndexViewModelRow;
import uk.co.luciditysoftware.campervibe.site.viewmodels.booking.MakeViewModel;
import uk.co.luciditysoftware.campervibe.site.viewmodels.common.SelectListOption;

import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BookingController {

    private BookingRepository bookingRepository;
    private VehicleRepository vehicleRepository;

    //http://www.baeldung.com/spring-nosuchbeandefinitionexception
    
	@Inject
	public void setBookingRepository(BookingRepository bookingRepository) {
		this.bookingRepository = bookingRepository;
	}
   
	@Inject
	public void setVehicleRepository(VehicleRepository vehicleRepository) {
		this.vehicleRepository = vehicleRepository;
	}
	
	@ResponseBody
    @RequestMapping(value = "/booking/index", method = RequestMethod.GET)
    public ModelAndView index(Map<String, Object> model)
    {
		IndexViewModel viewModel = getIndexViewModel();
        return new ModelAndView("booking/index", "viewModel", viewModel);
    }

	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	private IndexViewModel getIndexViewModel() {
		Session session = Bootstrap.sessionFactory.openSession();
		ThreadLocalSessionContext.bind(session);
		List<Booking> bookings = bookingRepository.getAll();
	    IndexViewModel viewModel = new IndexViewModel();
	    
	    viewModel.setBookings(bookings
	    		.stream()
				.map(booking -> new IndexViewModelRow(booking))
				.collect(Collectors.toList()));
	    
	    return viewModel;
	}
	
	@RequestMapping(value = "/booking/make", method = RequestMethod.GET)
    public ModelAndView make() {
		MakeViewModel viewModel = getMakeViewModel();
        return new ModelAndView("booking/make", "viewModel", viewModel);
    }

	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	private MakeViewModel getMakeViewModel() {
		Session session = Bootstrap.sessionFactory.openSession();
		ThreadLocalSessionContext.bind(session);
		List<Vehicle> vehicles = vehicleRepository.getAll();
		MakeViewModel viewModel = new MakeViewModel();
		
		viewModel.setVehicleOptions(vehicles
				.stream()
				.map(vehicle -> new SelectListOption()
				{{
					setText(vehicle.getName());
					setValue(vehicle.getId());
				}})
				.collect(Collectors.toList()));
		
		return viewModel;
	}
	
	/**
	 * 
	 * @param session
	 * @param viewModel
	 * @return
	 * @throws IOException
	 * Needs to have the /post part on the end because of the filters - no way to distinguish between POST and GET methods. Otherwise
	 * could just use /booking/make and would use this method because of method.
	 */
	@RequestMapping(value = "/booking/make", method = RequestMethod.POST)
	@Transactional(propagation=Propagation.REQUIRED, readOnly=false)
    public View make(HttpSession session, MakeViewModel viewModel) throws IOException {
		
		Session hibernateSession = Bootstrap.sessionFactory.openSession();
		ThreadLocalSessionContext.bind(hibernateSession);
		
		Vehicle vehicle = vehicleRepository
				.getAll()
				.stream()
				.filter(x -> x.getId().equals(viewModel.getVehicleId()))
				.findFirst()
				.get();
		
		MakeRequest makeRequest = new MakeRequest();
		makeRequest.setVehicle(vehicle);
		makeRequest.setStartDate(viewModel.getStartDate());
		makeRequest.setEndDate(viewModel.getEndDate());
		Booking booking = Booking.make(makeRequest);
		bookingRepository.save(booking);
        return new RedirectView("index");
    }
}
