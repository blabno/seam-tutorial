package pl.itcrowd.tutorials.itc.security;

import org.jboss.seam.security.Identity;
import org.jboss.seam.security.annotations.Secures;

public class Authorizer {

    @Secures
    @Admin
    public boolean isAdmin(Identity identity)
    {
        return identity.hasRole("admin", "USERS", "GROUP");
    }
}
