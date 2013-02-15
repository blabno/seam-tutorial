package pl.itcrowd.tutorials.itc;

import org.jboss.seam.transaction.Transactional;
import org.jboss.solder.servlet.WebApplication;
import org.jboss.solder.servlet.event.Initialized;
import pl.itcrowd.tutorials.itc.domain.User;
import pl.itcrowd.tutorials.itc.framework.Standalone;

import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.persistence.EntityManager;

public class Startup {

    @Standalone
    @Inject
    private EntityManager entityManager;

    @Transactional
    public void seed(@Observes @Initialized WebApplication webApplication)
    {
        entityManager.persist(new User("bernard@itcrowd.pl", "aaaaa", "admin"));
        entityManager.persist(new User("jack@itcrowd.pl", "aaaaa", "user"));
        entityManager.flush();
    }
}
