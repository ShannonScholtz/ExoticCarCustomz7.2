package ExoticCarCustomz.repository;

import ExoticCarCustomz.domain.Car;
import org.springframework.data.repository.CrudRepository;


/**
 * Created by student on 2015/04/15.
 */
public interface CarRepository extends CrudRepository<Car, Long> {

    public Car findbySerialNumber(String serialNumber);
}
