package pl.itcrowd.tutorials.itc.dao;

import pl.itcrowd.tutorials.itc.domain.User;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@ApplicationScoped
public class UserDAO {

    private List<User> users;

    public UserDAO()
    {
        users = new ArrayList<User>();
        users.add(new User("bernard@itcrowd.pl", "aaaaa", "admin"));
        users.add(new User("jack@itcrowd.pl", "aaaaa", "user"));
    }

    public List<User> getAllUsers()
    {
        return Collections.unmodifiableList(users);
    }

    public User getUserByEmail(String email)
    {
        for (User user : users) {
            if (email.equals(user.getEmail())) {
                return user;
            }
        }
        return null;
    }

    public void remove(User user)
    {
        users.remove(user);
    }
}
