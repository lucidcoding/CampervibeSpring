package uk.co.luciditysoftware.campervibe.site.security;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

public class UserPrincipal  implements Authentication, Cloneable{
	private static final long serialVersionUID = 1L;

    private long id;

    private String username;

    private byte[] password;

    private boolean authenticated;


    public long getId()
    {
        return this.id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public String getUsername()
    {
        return this.username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public byte[] getPassword()
    {
        return this.password;
    }

    public void setPassword(byte[] password)
    {
        this.password = password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities()
    {
        return Arrays.asList();
    }

    @Override
    public String getName()
    {
        return this.username;
    }

    @Override
    public Object getPrincipal()
    {
        return this.username;
    }

    @Override
    public Object getDetails()
    {
        return this.username;
    }

    @Override
    public Object getCredentials()
    {
        return this.password;
    }

    @Override
    public boolean isAuthenticated()
    {
        return this.authenticated;
    }

    @Override
    public void setAuthenticated(boolean authenticated)
    {
        this.authenticated = authenticated;
    }

    @Override
    public int hashCode()
    {
        return this.username.hashCode();
    }

    @Override
    public boolean equals(Object other)
    {
        return other instanceof UserPrincipal &&
                ((UserPrincipal)other).username.equals(this.username);
    }

    @Override
    @SuppressWarnings("CloneDoesntDeclareCloneNotSupportedException")
    protected UserPrincipal clone()
    {
        try {
            return (UserPrincipal)super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e); // not possible
        }
    }

    @Override
    public String toString()
    {
        return this.username;
    }
}
