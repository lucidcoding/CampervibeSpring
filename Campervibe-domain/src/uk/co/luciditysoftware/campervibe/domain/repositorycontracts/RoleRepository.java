package uk.co.luciditysoftware.campervibe.domain.repositorycontracts;

import java.util.UUID;

import uk.co.luciditysoftware.campervibe.domain.entities.Role;

public interface RoleRepository {
	public Role getById(UUID id);
}
