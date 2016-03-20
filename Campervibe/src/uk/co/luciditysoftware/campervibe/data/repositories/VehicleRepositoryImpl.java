package uk.co.luciditysoftware.campervibe.data.repositories;

import java.util.List;
import java.util.UUID;

import org.hibernate.Session;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import uk.co.luciditysoftware.campervibe.config.Bootstrap;
import uk.co.luciditysoftware.campervibe.domain.entities.Vehicle;
import uk.co.luciditysoftware.campervibe.domain.repositorycontracts.VehicleRepository;

@Repository
@Scope("prototype")
public class VehicleRepositoryImpl implements VehicleRepository {

	@Override
	public Vehicle getById(UUID id) {
		Session session = Bootstrap.sessionFactory.getCurrentSession();
		Vehicle vehicle = (Vehicle)session.get(Vehicle.class, id);
		return vehicle;
	}
	
	@Override
	public List<Vehicle> getAll() {
		Session session = Bootstrap.sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Vehicle> vehicles = session.createCriteria(Vehicle.class).list();
		return vehicles;
	}
}
