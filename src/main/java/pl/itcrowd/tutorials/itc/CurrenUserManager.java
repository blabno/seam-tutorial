package pl.itcrowd.tutorials.itc;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Named;
import java.io.Serializable;

@Named
@SessionScoped
public class CurrenUserManager implements Serializable {

    private User user;

    public void login()
    {
        this.user = new User();
        this.user.setEmail("Jack@lando.pl");
    }

    @Named
    @CurrentUser
    @Produces
    private User getCurrentUser()
    {
        return user == null ? new User() : user;
    }
}
