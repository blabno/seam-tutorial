package pl.itcrowd.tutorials.itc.business.user;

import pl.itcrowd.tutorials.itc.dao.UserDAO;
import pl.itcrowd.tutorials.itc.domain.User;
import pl.itcrowd.tutorials.itc.security.Admin;

import javax.inject.Inject;
import java.util.List;

public class UserManager {

    @Inject
    private UserDAO userDAO;

    public List<User> getAllUsers()
    {
        return userDAO.getAllUsers();
    }

    @Admin
    public void remove(User user)
    {
        userDAO.remove(user);
    }
}
