package ExoticCarCustomz.repository;

import ExoticCarCustomz.App;
import ExoticCarCustomz.domain.Mechanic;
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
public class CrudMechanicTest {

    private Long id;

    @Autowired
    MechanicRepository repository;
    @Test
    public void testCreate() throws Exception {
        List<Mechanic> mec = new ArrayList<Mechanic>();
        Mechanic mechan = new Mechanic.Builder("Rama").FirstName("Ethon").build();
        repository.save(mechan);
        id= mechan.getMechanicID();
        Assert.assertNotNull(mechan.getMechanicID());
    }

    @Test
    public void testRead() throws Exception {
        Mechanic mech = repository.findOne(id);
        Assert.assertEquals("Rama", mech.getLastName());
    }

    @Test
    public void testUpdate() throws Exception {

        Mechanic mec = repository.findOne(id);
        Mechanic newcourse = new Mechanic.Builder("Rama")
                .mechanicID(mec.getMechanicID()).FirstName("Ethon").build();
        repository.save(newcourse);
        Assert.assertEquals("Rama", mec.getLastName());
        Assert.assertEquals("Ethon", mec.getFirstName());

    }

    @Test
    public void testDelete() throws Exception {
        Mechanic mec = repository.findOne(id);
        repository.delete(mec);
        Mechanic mechan = repository.findOne(id);
        Assert.assertNull(mechan);


    }
}
