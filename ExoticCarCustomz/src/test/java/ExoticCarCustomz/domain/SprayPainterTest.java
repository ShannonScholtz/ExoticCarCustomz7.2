package ExoticCarCustomz.domain;

import ExoticCarCustomz.conf.factory.SprayPainterFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by student on 2015/04/16.
 */
public class SprayPainterTest {

    @Before
    public void setUp() throws Exception {

    }


    @Test
    public void testCreateSprayPainter() throws Exception {
        List<BodyParts> bodyparts = new ArrayList<BodyParts>();

        SprayPainter painter = SprayPainterFactory
                .createSprayPainter("Tseleng", "Rudy", bodyparts);

        Assert.assertEquals("Rudy", painter.getFirstName());
        Assert.assertEquals("Tseleng", painter.getLastName());
    }

    @Test
    public void testUpdateSprayPainter() throws Exception {
        List<BodyParts> bodyparts = new ArrayList<BodyParts>();

        SprayPainter painter = SprayPainterFactory
                .createSprayPainter("Tseleng", "Rudy", bodyparts);


        SprayPainter newname = new SprayPainter
                .Builder(painter.getLastName())
                .copy(painter)
                .FirstName("Molemo")
                .build();

        Assert.assertEquals("Tseleng", newname.getLastName());
        Assert.assertEquals("Molemo", newname.getFirstName());
        Assert.assertEquals("Rudy", painter.getFirstName());


    }
}
