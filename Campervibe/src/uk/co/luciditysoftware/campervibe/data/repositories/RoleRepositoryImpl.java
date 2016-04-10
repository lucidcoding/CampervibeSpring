package uk.co.luciditysoftware.campervibe.data.repositories;

import java.util.UUID;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import uk.co.luciditysoftware.campervibe.domain.entities.Role;
import uk.co.luciditysoftware.campervibe.domain.repositorycontracts.RoleRepository;

@Repository
@Scope("prototype")
public class RoleRepositoryImpl implements RoleRepository {

	private SessionFactory sessionFactory;

	@Inject 
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public Role getById(UUID id) {
		Session session = sessionFactory.getCurrentSession();
		Role role = (Role)session.get(Role.class, id);
		return role;
	}
}
