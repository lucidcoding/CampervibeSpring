package uk.co.luciditysoftware.campervibe.config;

import javax.inject.Inject;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;

import uk.co.luciditysoftware.campervibe.site.security.AuthenticationService;

@Configuration
@EnableWebMvcSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter
{
	private AuthenticationService authenticationService;
	
	@Inject
	public void setAuthenticationService(AuthenticationService authenticationService) {
		this.authenticationService = authenticationService;
	}
	
    @Override
    protected void configure(AuthenticationManagerBuilder builder)
            throws Exception
    {
        builder.authenticationProvider(this.authenticationService);
    }

    @Override
    public void configure(WebSecurity security)
    {
        security.ignoring().antMatchers("/resource/**");
    }

    @Override
    protected void configure(HttpSecurity security) throws Exception
    {
        security
                .authorizeRequests()
                    .antMatchers("/account/register", "/about", "/policies", "/booking/make").permitAll()
                    .antMatchers("/booking/index").hasAuthority("ViewAllBookings")
                    .antMatchers("/booking/make").hasAuthority("MakeBooking")
                    .anyRequest().authenticated()
                .and().formLogin()
                    .loginPage("/account/login").failureUrl("/account/login?error")
                    .defaultSuccessUrl("/secure/")
                    .usernameParameter("username")
                    .passwordParameter("password")
                    .permitAll()
                .and().logout()
                    .logoutUrl("/account/logout").logoutSuccessUrl("/account/login?loggedOut")
                    .invalidateHttpSession(true).deleteCookies("JSESSIONID")
                    .permitAll()
                .and().sessionManagement()
                    .sessionFixation().changeSessionId()
                    .maximumSessions(1).maxSessionsPreventsLogin(true)
                .and().and().csrf().disable();
    }
}
