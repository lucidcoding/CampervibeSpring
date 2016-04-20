package uk.co.luciditysoftware.campervibe.config;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Controller;

//Dependency gotchas:
//
//Child project can't access its own Maven dependencies:
//http://stackoverflow.com/questions/5603758/tomcat-throws-classnotfound-exceptions-for-classes-in-other-open-eclipse-project
//
//Can't access the hbm mapping files in a dependent project
//http://stackoverflow.com/questions/36374113/hibernate-hbm-mapping-file-referencing-entity-in-another-project

@Configuration
@ComponentScan(basePackages = {
		"uk.co.luciditysoftware.campervibe.site",
		"uk.co.luciditysoftware.campervibe.data.repositories"
}, 
excludeFilters = @ComponentScan.Filter(Controller.class) )
@Import({ SecurityConfiguration.class })
public class RootContextConfiguration {

	@Bean
	public SessionFactory sessionFactory() {
		@SuppressWarnings("deprecation")
		SessionFactory sessionFactory = new org.hibernate.cfg.Configuration()
				.configure("/uk/co/luciditysoftware/campervibe/config/hibernate.cfg.xml")
				.buildSessionFactory();

		return sessionFactory;
	}
}
