package pl.itcrowd.tutorials.itc.security;

import org.jboss.seam.security.Identity;
import org.jboss.seam.security.annotations.Secures;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class Authorizer {

    private Identity identity;

    public Authorizer()
    {
    }

    @Inject
    public Authorizer(Identity identity)
    {
        this.identity = identity;
    }

    @Secures
    @Admin
    public boolean isAdmin()
    {
        return identity.hasRole("admin", "USERS", "GROUP");
    }
}
