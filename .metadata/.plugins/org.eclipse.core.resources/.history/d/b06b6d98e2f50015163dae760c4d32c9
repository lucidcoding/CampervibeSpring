package uk.co.luciditysoftware.campervibe.config;

import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Controller;

@Configuration
@ComponentScan(basePackages = {
		"uk.co.luciditysoftware.campervibe" }, excludeFilters = @ComponentScan.Filter(Controller.class) )
@Import({ SecurityConfiguration.class })
public class RootContextConfiguration {

	@Bean
	public SessionFactory sessionFactory() {
		SessionFactory sessionFactory = new org.hibernate.cfg.Configuration()
				.configure("/uk/co/luciditysoftware/campervibe/config/hibernate.cfg.xml").buildSessionFactory();

		return sessionFactory;
	}
}
