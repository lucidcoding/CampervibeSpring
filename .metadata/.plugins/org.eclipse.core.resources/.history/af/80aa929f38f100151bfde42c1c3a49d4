package uk.co.luciditysoftware.campervibe.site.controllers;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.context.internal.ThreadLocalSessionContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
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

	//http://forum.spring.io/forum/spring-projects/data/130853-injecting-hibernate-sessionfactory-when-using-localcontainerentitymanagerfactorybean
	//http://patrickgrimard.com/2009/12/08/spring-mvc-and-hibernate-made-simple-with-annotations/
	//http://stackoverflow.com/questions/6446857/spring-using-factory-beans-in-configuration
	//https://github.com/pgrimard/hibernate1/blob/master/src/main/webapp/WEB-INF/test-servlet.xml
	private SessionFactory sessionFactory;
	private BookingRepository bookingRepository;
	private VehicleRepository vehicleRepository;

	@Inject 
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
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
	public ModelAndView index(Map<String, Object> model) {
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		List<Booking> bookings = bookingRepository.getAll();
		IndexViewModel viewModel = new IndexViewModel();

		viewModel.setBookings(
				bookings.stream().map(booking -> new IndexViewModelRow(booking)).collect(Collectors.toList()));

		transaction.commit();
		return new ModelAndView("booking/index", "viewModel", viewModel);
	}

	@RequestMapping(value = "/booking/make", method = RequestMethod.GET)
	public ModelAndView make() {
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		List<Vehicle> vehicles = vehicleRepository.getAll();
		MakeViewModel viewModel = new MakeViewModel();

		viewModel.setVehicleOptions(vehicles.stream().map(vehicle -> new SelectListOption() {
			{
				setText(vehicle.getName());
				setValue(vehicle.getId());
			}
		}).collect(Collectors.toList()));

		transaction.commit();
		return new ModelAndView("booking/make", "viewModel", viewModel);
	}
	
	@RequestMapping(value = "/booking/pendingforvehicle/{vehicleId}", method = RequestMethod.GET)
	public ModelAndView pendingForVehicle(@PathVariable("vehicleId") UUID vehicleId) {
		return new ModelAndView("booking/pendingForVehicle");
	}

	@RequestMapping(value = "/booking/make", method = RequestMethod.POST)
	public View make(HttpSession httpSession, MakeViewModel viewModel) throws IOException {
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		MakeRequest makeRequest = new MakeRequest();
		makeRequest.setVehicle(vehicleRepository.getById(viewModel.getVehicleId()));
		makeRequest.setStartDate(viewModel.getStartDate());
		makeRequest.setEndDate(viewModel.getEndDate());
		Booking booking = Booking.make(makeRequest);
		bookingRepository.save(booking);
		transaction.commit();
		return new RedirectView("index");
	}
}
