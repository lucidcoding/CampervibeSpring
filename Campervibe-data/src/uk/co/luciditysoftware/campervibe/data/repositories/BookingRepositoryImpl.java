package uk.co.luciditysoftware.campervibe.data.repositories;

import java.util.List;
import java.util.UUID;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import uk.co.luciditysoftware.campervibe.domain.entities.Booking;
import uk.co.luciditysoftware.campervibe.domain.repositorycontracts.BookingRepository;

@Repository
@Scope("prototype")
public class BookingRepositoryImpl implements BookingRepository {

	private SessionFactory sessionFactory;

	@Inject 
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	
	@Override
	public Booking getById(UUID id) {
		Session session = sessionFactory.getCurrentSession();
		/*SessionFactory sessionFactory = new org.hibernate.cfg.Configuration()
				.configure("/uk/co/luciditysoftware/campervibe/config/hibernate.cfg.xml")
				.buildSessionFactory();
		
		Session session = sessionFactory.getCurrentSession();*/
		Booking booking = (Booking)session.get(Booking.class, id);
		return booking;
	}
	
	@Override
	public List<Booking> getAll() {
		Session session = sessionFactory.getCurrentSession();
		/*SessionFactory sessionFactory = new org.hibernate.cfg.Configuration()
				.configure("/uk/co/luciditysoftware/campervibe/config/hibernate.cfg.xml")
				.buildSessionFactory();
		
		Session session = sessionFactory.getCurrentSession();*/
		@SuppressWarnings("unchecked")
		List<Booking> bookings = session.createCriteria(Booking.class).list();
		return bookings;
	}

	@Override
	public void save(Booking booking) {
		Session session = sessionFactory.getCurrentSession();
		/*SessionFactory sessionFactory = new org.hibernate.cfg.Configuration()
				.configure("/uk/co/luciditysoftware/campervibe/config/hibernate.cfg.xml")
				.buildSessionFactory();
		
		Session session = sessionFactory.getCurrentSession();*/
		session.save(booking);
		return;
	}
}
