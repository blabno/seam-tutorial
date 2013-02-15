package pl.itcrowd.tutorials.itc.view.car;

import org.jboss.seam.international.status.Messages;
import org.jboss.seam.international.status.builder.BundleKey;
import pl.itcrowd.tutorials.itc.dao.CarDAO;
import pl.itcrowd.tutorials.itc.domain.Car;
import pl.itcrowd.tutorials.itc.framework.Removed;
import pl.itcrowd.tutorials.itc.framework.Selected;

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

    @Inject
    private Messages messages;

    public List<Car> getCars()
    {
        return carDAO.getAllCars();
    }

    public void remove(Car car)
    {
        carDAO.remove(car);
        carRemovedEvent.fire(car);
        messages.info(new BundleKey("messages", "pl.itcrowd.tutorials.itc.view.car.CarListView.carRemoved"), car.getModel());
    }

    public void select(Car car)
    {
        carEvent.select(new AnnotationLiteral<Selected>() {
        }).fire(car);
    }
}
