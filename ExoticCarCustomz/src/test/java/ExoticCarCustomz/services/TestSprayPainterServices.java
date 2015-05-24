package ExoticCarCustomz.services;

import ExoticCarCustomz.App;
import ExoticCarCustomz.conf.factory.SprayPainterFactory;
import ExoticCarCustomz.domain.SprayPainter;
import ExoticCarCustomz.repository.SprayPainterRepository;
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
public class TestSprayPainterServices extends AbstractTestNGSpringContextTests {
    @Autowired
    private SprayPainterServices service;

    private Long id;

    @Autowired
    private SprayPainterRepository repository;
    private Map<String, String> values;

    @Before
    public void setUp() throws Exception {
        values = new HashMap<String, String>();
    }

    @Test
    public void create() throws Exception {

        values.put("LastName", "Tseleng");
        values.put("FirstName", "Rudy");

        SprayPainter painter = SprayPainterFactory
                .createSprayPainter(values);

        repository.save(painter);
        id= painter.getPainterID();
        Assert.assertNotNull(painter.getPainterID());
    }

}
 */