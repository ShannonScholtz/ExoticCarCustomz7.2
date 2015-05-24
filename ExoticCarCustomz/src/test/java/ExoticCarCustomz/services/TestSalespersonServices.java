package ExoticCarCustomz.services;

import ExoticCarCustomz.App;
import ExoticCarCustomz.conf.factory.SalespersonFactory;
import ExoticCarCustomz.domain.Salesperson;
import ExoticCarCustomz.repository.SalesPersonRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

/**
 * Created by student on 2015/05/10.

@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class TestSalespersonServices extends AbstractTestNGSpringContextTests {
    @Autowired
    private SalespersonServices service;

    private Long id;

    @Autowired
    private SalesPersonRepository repository;


    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void create() throws Exception {

        Salesperson salesperson = SalespersonFactory
                .createSalesperson("Janet", "Jackson");

        repository.save(salesperson);
        id= salesperson.getSalespersonID();
        Assert.assertNotNull(salesperson.getSalespersonID());
    }

}
 */