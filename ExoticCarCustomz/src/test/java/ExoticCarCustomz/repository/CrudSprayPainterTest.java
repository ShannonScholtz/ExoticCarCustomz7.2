package ExoticCarCustomz.repository;


import ExoticCarCustomz.App;
import ExoticCarCustomz.domain.SprayPainter;
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
public class CrudSprayPainterTest {

    private Long id;

    @Autowired
    SprayPainterRepository repository;
    @Test
    public void testCreate() throws Exception {
        List<SprayPainter> painter = new ArrayList<SprayPainter>();
        SprayPainter spray = new SprayPainter.Builder("Zeeman").FirstName("Rudy").build();
        repository.save(spray);
        id= spray.getPainterID();
        Assert.assertNotNull(spray.getPainterID());
    }

    @Test
    public void testRead() throws Exception {
        SprayPainter spainter = repository.findOne(id);
        Assert.assertEquals("Zeeman", spainter.getLastName());
    }

    @Test
    public void testUpdate() throws Exception {

        SprayPainter spray = repository.findOne(id);
        SprayPainter newcourse = new SprayPainter.Builder("Johnson").painterID(spray.getPainterID())
                .FirstName("Scott").build();
        repository.save(newcourse);
        Assert.assertEquals("Johnson", spray.getLastName());
        Assert.assertEquals("Scott", spray.getFirstName());

    }

    @Test
    public void testDelete() throws Exception {
        SprayPainter spray = repository.findOne(id);
        repository.delete(spray);
        SprayPainter paint = repository.findOne(id);
        Assert.assertNull(paint);


    }
}
