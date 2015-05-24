package ExoticCarCustomz.repository;

import ExoticCarCustomz.App;
import ExoticCarCustomz.domain.Car;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/04/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class CrudCarTest {

    private Long id;

    @Autowired
    CarRepository repository;
    @Test
    public void testCreate() throws Exception {
        List<Car> car = new ArrayList<Car>();
        Car carz = new Car.Builder("23445VWGTI6").make("VW").model("Golf 6").year("2014").build();
        repository.save(carz);
        id= carz.getCarID();
        Assert.assertNotNull(carz.getCarID());
    }

    @Test
    public void testRead() throws Exception {
        Car car = repository.findOne(id);
        Assert.assertEquals("VW",car.getMake());
    }

    @Test
    public void testUpdate() throws Exception {

        Car car = repository.findOne(id);
        Car cars = new Car.Builder("23445VWGTI5")
                .carID(car.getCarID()).make("VW").model("Golf 5").year("2012").build();
        repository.save(cars);
        Assert.assertEquals("23445VWGTI5", car.getSerialNumber());
        Assert.assertEquals("VW", car.getMake());
        Assert.assertEquals("Golf 5", car.getModel());
        Assert.assertEquals("2012", car.getYear());

    }

    @Test
    public void testDelete() throws Exception {
        Car c = repository.findOne(id);
        repository.delete(c);
        Car cars = repository.findOne(id);
        Assert.assertNull(cars);


    }
}
