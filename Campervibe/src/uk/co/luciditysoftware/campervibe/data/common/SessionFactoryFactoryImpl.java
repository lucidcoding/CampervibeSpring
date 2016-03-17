package uk.co.luciditysoftware.campervibe.data.common;

import java.util.UUID;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;

@Component
public class SessionFactoryFactoryImpl implements SessionFactoryFactory {

	private SessionFactory sessionFactory;
	public UUID id;

	private SessionFactoryFactoryImpl() {
		sessionFactory = new Configuration()
			.configure("/uk/co/luciditysoftware/campervibe/config/hibernate.cfg.xml")
			.buildSessionFactory();
		
		id = UUID.randomUUID();
	}
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
