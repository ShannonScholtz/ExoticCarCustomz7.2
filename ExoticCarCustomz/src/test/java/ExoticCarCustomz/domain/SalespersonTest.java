package ExoticCarCustomz.domain;

import ExoticCarCustomz.conf.factory.SalespersonFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by student on 2015/04/16.
 */
public class SalespersonTest {

    @Before
    public void setUp() throws Exception {


    }

    @Test
    public void testCreateSalesperson() throws Exception {
        Salesperson technician = SalespersonFactory
                .createSalesperson("Johnson", "Peter");

        Assert.assertEquals("Peter", technician.getFirstName());
        Assert.assertEquals("Johnson", technician.getLastName());
    }

    @Test
    public void testUpdateSalesperson() throws Exception {
        Salesperson salesperson = SalespersonFactory
                .createSalesperson("Johnson", "Peter");

        Salesperson newname = new Salesperson
                .Builder(salesperson.getLastName())
                .copy(salesperson)
                .FirstName("Jacky")
                .build();

        Assert.assertEquals("Johnson", newname.getLastName());
        Assert.assertEquals("Jacky", newname.getFirstName());
        Assert.assertEquals("Peter", salesperson.getFirstName());


    }
}
