package ExoticCarCustomz.repository;

import ExoticCarCustomz.App;
import ExoticCarCustomz.domain.MechanicalParts;
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
public class CrudMechanicalPartsTest {

    private Long id;

    @Autowired
    MechanicalPartsRepository repository;
    @Test
    public void testCreate() throws Exception {
        List<MechanicalParts> mp = new ArrayList<MechanicalParts>();
        MechanicalParts mparts = new MechanicalParts.Builder("Positive camber").Price(8099.99).build();
        repository.save(mparts);
        id= mparts.getMechanicalPartID();
        Assert.assertNotNull(mparts.getMechanicalPartID());
    }

    @Test
    public void testRead() throws Exception {
        MechanicalParts mp = repository.findOne(id);
        Assert.assertEquals("Positive camber",mp.getDescription());
    }

    @Test
    public void testUpdate() throws Exception {

        MechanicalParts mp = repository.findOne(id);
        MechanicalParts mparts = new MechanicalParts.Builder("Air Suspension")
                .mechanicalPartID(mp.getMechanicalPartID()).Price(15000.00).build();;
        repository.save(mparts);
        Assert.assertEquals("Air Suspension", mp.getDescription());
        Assert.assertEquals(15000.00, mp.getPrice(), 15000.00);

    }

    @Test
    public void testDelete() throws Exception {
        MechanicalParts mp = repository.findOne(id);
        repository.delete(mp);
        MechanicalParts mparts = repository.findOne(id);
        Assert.assertNull(mparts);


    }
}
