package ExoticCarCustomz.services.impl;

import ExoticCarCustomz.domain.Car;
import ExoticCarCustomz.repository.CarRepository;
import ExoticCarCustomz.services.CarServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/04/16.
 */
@Service
public class CarImpl implements CarServices {
    @Autowired
    CarRepository repository;
    public List<Car> getCar() {
        List<Car> allcars = new ArrayList<Car>();

        Iterable<Car> cars = repository.findAll();
        for (Car car : cars) {
            allcars.add(car);
        }
        return allcars;
    }
}
