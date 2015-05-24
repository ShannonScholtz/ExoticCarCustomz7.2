package ExoticCarCustomz.conf.factory;



import ExoticCarCustomz.domain.Car;

import java.util.Map;

/**
 * Created by student on 2015/04/23.
 */
public class CarFactory {

    public static Car createCar(String serialNumber, String make, String model, String colour, String year) {
        Car cars = new Car
                .Builder(serialNumber)
                .make(make)
                .model(model)
                .colour(colour)
                .year(year)
                .build();
        return cars;
    }
}
