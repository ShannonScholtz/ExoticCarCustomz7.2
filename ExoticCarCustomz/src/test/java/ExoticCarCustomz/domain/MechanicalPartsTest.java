package ExoticCarCustomz.domain;

import ExoticCarCustomz.conf.factory.MechanicalPartsFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by student on 2015/04/16.
 */
public class MechanicalPartsTest {

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void testCreateMechanicalParts() throws Exception {

        MechanicalParts equipment = MechanicalPartsFactory
                .createMechanicalParts(5000.00, "garret t4 turbo");

        Assert.assertEquals(5000.00, equipment.getPrice(), 5000.00);
    }

    @Test
    public void testUpdateMechanicalParts() throws Exception {

        MechanicalParts parts = MechanicalPartsFactory
                .createMechanicalParts(5000.00, "garret t4 turbo");

        MechanicalParts newpart = new MechanicalParts
                .Builder(parts.getDescription())
                .copy(parts)
                .Price(6000.00)
                .build();

        Assert.assertEquals("garret t4 turbo", newpart.getDescription());
        Assert.assertEquals(6000.00, newpart.getPrice(), 6000.00);
        Assert.assertEquals(5000.00, parts.getPrice(), 5000.00);


    }
}
