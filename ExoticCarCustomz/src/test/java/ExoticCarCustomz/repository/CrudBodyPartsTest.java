package ExoticCarCustomz.repository;

import ExoticCarCustomz.App;
import ExoticCarCustomz.domain.BodyParts;
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
public class CrudBodyPartsTest {

    private Long id;

    @Autowired
    BodyPartsRepository repository;
    @Test
    public void testCreate() throws Exception {
        List<BodyParts> parts = new ArrayList<BodyParts>();
        BodyParts bparts = new BodyParts.Builder("Side-Skirts").Colour("Ferrari Red").Price(10999.99).build();
        repository.save(bparts);
        id = bparts.getBodyPartID();
        Assert.assertNotNull(bparts.getBodyPartID());
    }

    @Test
    public void testRead() throws Exception {
        BodyParts parts = repository.findOne(id);
        Assert.assertEquals("Side-Skirts",parts.getBodyStylingModifications());
    }

    @Test
    public void testUpdate() throws Exception {

        BodyParts parts = repository.findOne(id);
        BodyParts newcourse = new BodyParts.Builder("Sun-roof")
                .BodyPartID(parts.getBodyPartID()).Colour("Pearl white").Price(10999.99).build();
        repository.save(newcourse);
        Assert.assertEquals("Sun-roof", parts.getBodyStylingModifications());
        Assert.assertEquals("Pearl white", parts.getColour());
        Assert.assertEquals(10999.99, parts.getPrice(), 10999.99);

    }

    @Test
    public void testDelete() throws Exception {
        BodyParts dltparts = repository.findOne(id);
        repository.delete(dltparts);
        BodyParts dltbody = repository.findOne(id);
        Assert.assertNull(dltbody);


    }
}
