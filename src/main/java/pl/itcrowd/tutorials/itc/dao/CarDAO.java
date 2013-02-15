package pl.itcrowd.tutorials.itc.dao;

import pl.itcrowd.tutorials.itc.domain.Car;

import javax.enterprise.context.ApplicationScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class CarDAO implements Serializable {

    private List<Car> cars = new ArrayList<Car>();

    public CarDAO()
    {
        this.cars.add(new Car("Pontiac"));
        this.cars.add(new Car("Polonez"));
        this.cars.add(new Car("Mazda"));
    }

    public List<Car> getAllCars()
    {
        return new ArrayList<Car>(cars);
    }

    public void remove(Car car)
    {
        cars.remove(car);
    }
}
