package ExoticCarCustomz.api;

import ExoticCarCustomz.domain.Car;
import ExoticCarCustomz.services.CarServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

/**
 * Created by student on 2015/04/15.
 */
@RestController
@RequestMapping("/api/**")
public class HomePage {
    @Autowired
    private CarServices service;
    @RequestMapping(value = "home",method = RequestMethod.GET)
    public String Index(){
        return "This is a Home Page";
    }

    @RequestMapping(value = "/car",method = RequestMethod.GET)
    public Car getCar(){
        Car cars= new Car.Builder("122323")
                .make("VW").model("GTI").year("2013").build();

        return cars;
    }

    @RequestMapping(value = "/car", method = RequestMethod.GET)
    public List<Car> getCars(){


        return service.getCar();



    }
}
