package uk.co.luciditysoftware.campervibe.site.domain.repositorycontracts;

import java.util.List;

import uk.co.luciditysoftware.campervibe.site.domain.entities.Vehicle;

public interface VehicleRepository {
	public List<Vehicle> getAll();
}
