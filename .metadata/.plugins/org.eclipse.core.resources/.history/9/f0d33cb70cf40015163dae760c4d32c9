package uk.co.luciditysoftware.campervibe.config;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@ComponentScan(
        basePackages = {
        		"uk.co.luciditysoftware.campervibe.site",
        		"uk.co.luciditysoftware.campervibe.data"
        },
        useDefaultFilters = false,
        includeFilters = @ComponentScan.Filter(Controller.class)
)
public class ServletContextConfiguration extends WebMvcConfigurerAdapter
{
	@Bean
    public ViewResolver viewResolver()
    {
        InternalResourceViewResolver resolver =
                new InternalResourceViewResolver();
        resolver.setViewClass(JstlView.class);
        resolver.setPrefix("/WEB-INF/jsp/view/");
        resolver.setSuffix(".jsp");
        return resolver;
    }

}