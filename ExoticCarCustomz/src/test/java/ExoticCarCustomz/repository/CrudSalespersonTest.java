package ExoticCarCustomz.repository;

import ExoticCarCustomz.App;
import ExoticCarCustomz.domain.Salesperson;
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
public class CrudSalespersonTest {

    private Long id;

    @Autowired
    SalesPersonRepository repository;
    @Test
    public void testCreate() throws Exception {
        List<Salesperson> person = new ArrayList<Salesperson>();
        Salesperson sal = new Salesperson.Builder("Daries").FirstName("Beatrix").build();
        repository.save(sal);
        id= sal.getSalespersonID();
        Assert.assertNotNull(sal.getSalespersonID());
    }

    @Test
    public void testRead() throws Exception {
        Salesperson sales = repository.findOne(id);
        Assert.assertEquals("National Diploma IT", sales.getLastName());
    }

    @Test
    public void testUpdate() throws Exception {

        Salesperson sals = repository.findOne(id);
        Salesperson newcourse = new Salesperson.Builder("Peters").salespersonID(sals.getSalespersonID())
                .FirstName("Agness").build();
        repository.save(newcourse);
        Assert.assertEquals("Peters", sals.getLastName());
        Assert.assertEquals("Agness", sals.getFirstName());

    }

    @Test
    public void testDelete() throws Exception {
        Salesperson s = repository.findOne(id);
        repository.delete(s);
        Salesperson sp = repository.findOne(id);
        Assert.assertNull(sp);


    }
}
