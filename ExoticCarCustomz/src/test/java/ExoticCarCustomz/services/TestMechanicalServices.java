package ExoticCarCustomz.services;

import ExoticCarCustomz.App;
import ExoticCarCustomz.conf.factory.MechanicFactory;
import ExoticCarCustomz.domain.Mechanic;
import ExoticCarCustomz.repository.MechanicRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by student on 2015/05/10.

@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class TestMechanicalServices extends AbstractTestNGSpringContextTests {
    @Autowired
    private MechanicServices service;

    private Long id;

    @Autowired
    private MechanicRepository repository;
    private Map<String, String> values;

    @Before
    public void setUp() throws Exception {
        values = new HashMap<String, String>();
    }

    @Test
    public void create() throws Exception {

        values.put("LastName", "Simons");
        values.put("FirstName", "Rudy");

        Mechanic mechanic = MechanicFactory
                .createMechanic(values);

        repository.save(mechanic);
        id= mechanic.getMechanicID();
        Assert.assertNotNull(mechanic.getMechanicID());
    }
}
 */