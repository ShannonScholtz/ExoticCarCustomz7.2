package ExoticCarCustomz.domain;

import ExoticCarCustomz.conf.factory.CarFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by student on 2015/04/16.
 */
public class CarTest {

        @Before
        public void setUp() throws Exception {


        }

    @Test
    public void testCreateCar() throws Exception {
        Map<String,String> values = new HashMap<String,String>();


        Car car = CarFactory
                .createCar("20150607GTI7", "Volkswagen", "Golf 7 GTI", "Lime", "2015");

        Assert.assertEquals("20150607GTI7", car.getSerialNumber());
        Assert.assertEquals("Volkswagen", car.getMake());
        Assert.assertEquals("Golf 7 GTI", car.getModel());
        Assert.assertEquals("Lime", car.getColour());
        Assert.assertEquals("2015", car.getYear());
    }

    @Test
    public void testUpdateCar() throws Exception {
        Map<String,String> values = new HashMap<String,String>();

        Car car = CarFactory
                .createCar("20150607GTI7", "Volkswagen", "Golf 7 GTI", "Lime", "2015");

        Car newcolour = new Car
                .Builder(car.getSerialNumber())
                .copy(car)
                .make(car.getMake())
                .model(car.getModel())
                .colour("Red")
                .year(car.getYear())
                .build();


        Assert.assertEquals("20150607GTI7", newcolour.getSerialNumber());
        Assert.assertEquals("Volkswagen", newcolour.getMake());
        Assert.assertEquals("Golf 7 GTI", newcolour.getModel());
        Assert.assertEquals("Lime", car.getColour());
        Assert.assertEquals("Red", newcolour.getColour());
        Assert.assertEquals("2015", newcolour.getYear());

    }
}

