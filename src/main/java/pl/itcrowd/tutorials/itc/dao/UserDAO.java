package pl.itcrowd.tutorials.itc.dao;

import pl.itcrowd.tutorials.itc.domain.User;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

public class UserDAO {

    @Inject
    private EntityManager entityManager;

    @SuppressWarnings("unchecked")
    public List<User> getAllUsers()
    {
        return entityManager.createQuery("select u from User u").getResultList();
    }

    public User getUserByEmail(String email)
    {
        return entityManager.find(User.class, email);
    }

    public void remove(User user)
    {
        entityManager.remove(user);
        entityManager.flush();
    }
}
