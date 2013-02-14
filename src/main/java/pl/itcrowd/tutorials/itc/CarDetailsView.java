package pl.itcrowd.tutorials.itc;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@Named
@SessionScoped
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
