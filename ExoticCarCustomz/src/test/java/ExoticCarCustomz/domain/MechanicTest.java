package ExoticCarCustomz.domain;

import ExoticCarCustomz.conf.factory.MechanicFactory;
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
public class MechanicTest {

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void testCreateMechanic() throws Exception {
        List<MechanicalParts> parts = new ArrayList<MechanicalParts>();

        Mechanic technician = MechanicFactory
                .createMechanic("Simons", "Patrick", parts);

        Assert.assertEquals("Patrick", technician.getFirstName());
        Assert.assertEquals("Simons", technician.getLastName());
    }

    @Test
    public void testUpdateMechanic() throws Exception {
        List<MechanicalParts> parts = new ArrayList<MechanicalParts>();


        Mechanic mechanic = MechanicFactory
                .createMechanic("Simons", "Patrick", parts);

        Mechanic newname = new Mechanic
                .Builder(mechanic.getLastName())
                .copy(mechanic)
                .FirstName("Edmund")
                .build();

        Assert.assertEquals("Simons", newname.getLastName());
        Assert.assertEquals("Edmund", newname.getFirstName());
        Assert.assertEquals("Patrick", mechanic.getFirstName());


    }
}
