package uk.co.luciditysoftware.campervibe.data.repositories;

import java.util.List;
import java.util.UUID;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import uk.co.luciditysoftware.campervibe.config.Bootstrap;
import uk.co.luciditysoftware.campervibe.domain.entities.Vehicle;
import uk.co.luciditysoftware.campervibe.domain.repositorycontracts.VehicleRepository;

@Repository
@Scope("prototype")
public class VehicleRepositoryImpl implements VehicleRepository {

	private SessionFactory sessionFactory;

	@Inject 
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public Vehicle getById(UUID id) {
		Session session = sessionFactory.getCurrentSession();
		Vehicle vehicle = (Vehicle)session.get(Vehicle.class, id);
		return vehicle;
	}
	
	@Override
	public List<Vehicle> getAll() {
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Vehicle> vehicles = session.createCriteria(Vehicle.class).list();
		return vehicles;
	}
}
