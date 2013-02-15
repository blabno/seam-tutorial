package pl.itcrowd.tutorials.itc.view;

import pl.itcrowd.tutorials.itc.business.user.UserManager;
import pl.itcrowd.tutorials.itc.domain.User;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
@RequestScoped
public class HomeView {

    @Inject
    private UserManager userManager;

    private List<User> users;

    public List<User> getUsers()
    {
        if (users == null) {
            users = userManager.getAllUsers();
        }
        return users;
    }

    public void removeUser(User user)
    {
        userManager.remove(user);
        users = null;
    }
}
