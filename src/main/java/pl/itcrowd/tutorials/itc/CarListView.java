package pl.itcrowd.tutorials.itc;

import javax.enterprise.event.Event;
import javax.enterprise.util.AnnotationLiteral;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class CarListView implements Serializable {

    @Inject
    private CarDAO carDAO;

    @Inject
    private Event<Car> carEvent;

    @Removed
    @Inject
    private Event<Car> carRemovedEvent;

    public List<Car> getCars()
    {
        return carDAO.getAllCars();
    }

    public void remove(Car car)
    {
        carDAO.remove(car);
        carRemovedEvent.fire(car);
    }

    public void select(Car car)
    {
        carEvent.select(new AnnotationLiteral<Selected>() {
        }).fire(car);
    }
}
