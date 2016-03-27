package uk.co.luciditysoftware.campervibe.site.security;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Collection;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    //private static final Logger log = LogManager.getLogger();
    private static final SecureRandom RANDOM;
    private static final int HASHING_ROUNDS = 10;

    static
    {
        try
        {
            RANDOM = SecureRandom.getInstanceStrong();
        }
        catch(NoSuchAlgorithmException e)
        {
            throw new IllegalStateException(e);
        }
    }


    //@Inject UserRepository userRepository;

    @Override
    //@Transactional
    public Authentication  authenticate(Authentication authentication)
    {
        UsernamePasswordAuthenticationToken credentials =
                (UsernamePasswordAuthenticationToken)authentication;
        String username = credentials.getPrincipal().toString();
        String password = credentials.getCredentials().toString();
        credentials.eraseCredentials();

        /*UserPrincipal principal = this.userRepository.getByUsername(username);
        if(principal == null)
        {
            log.warn("Authentication failed for non-existent user {}.", username);
            return null;
        }

        if(!BCrypt.checkpw(
                password,
                new String(principal.getPassword(), StandardCharsets.UTF_8)
        ))
        {
            log.warn("Authentication failed for user {}.", username);
            return null;
        }

        principal.setAuthenticated(true);
        log.debug("User {} successfully authenticated.", username);

        return principal;*/
    	
    	if (password.equals("password")) {
    		/*UserPrincipal userPrincipal = new UserPrincipal() {
				private static final long serialVersionUID = 1L;

				{
    				setUsername("Paul");
    				setAuthenticated(true);
    			}
    		};*/
    		
    		CustomUser user = new CustomUser() {
				private static final long serialVersionUID = 1L;

				{
    				setUsername("Paul");
    			}
    		};
    		
            Collection<? extends GrantedAuthority> authorities = user.getAuthorities();
            
            return new UsernamePasswordAuthenticationToken(user, password, authorities);
    	} else {
    		return null;
    	}	
    }

    @Override
    public boolean supports(Class<?> c)
    {
        return c == UsernamePasswordAuthenticationToken.class;
    }

    @Override
    //@Transactional
    public void saveUser(UserPrincipal principal, String newPassword)
    {
        /*if(newPassword != null && newPassword.length() > 0)
        {
            String salt = BCrypt.gensalt(HASHING_ROUNDS, RANDOM);
            principal.setPassword(BCrypt.hashpw(newPassword, salt).getBytes());
        }

        this.userRepository.save(principal);*/
    }
}

