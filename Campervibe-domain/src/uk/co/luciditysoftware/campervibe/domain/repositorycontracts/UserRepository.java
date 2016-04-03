package uk.co.luciditysoftware.campervibe.domain.repositorycontracts;

import java.util.UUID;

import uk.co.luciditysoftware.campervibe.domain.entities.User;

public interface UserRepository {
	public User getById(UUID id);
	public User getByUsername(String username);
	public void save(User user);
}
