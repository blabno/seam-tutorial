package pl.itcrowd.tutorials.itc.view.car;

import pl.itcrowd.tutorials.itc.domain.Car;
import pl.itcrowd.tutorials.itc.domain.User;
import pl.itcrowd.tutorials.itc.framework.Removed;
import pl.itcrowd.tutorials.itc.framework.Selected;
import pl.itcrowd.tutorials.itc.security.CurrentUser;

import javax.enterprise.event.Observes;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@Named
@ViewScoped
public class CarDetailsView implements Serializable {

    private Car car;

    @Inject
    @CurrentUser
    private User user;

    public Car getCar()
    {
        return car;
    }

    private void onCarRemoved(@Observes @Removed Car car)
    {
        this.car = null;
    }

    private void onCarSelected(@Observes @Selected Car car)
    {
        this.car = car;
    }
}
