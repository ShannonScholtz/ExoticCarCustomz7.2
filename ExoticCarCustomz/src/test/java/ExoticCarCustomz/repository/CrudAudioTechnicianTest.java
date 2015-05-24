package ExoticCarCustomz.repository;

import ExoticCarCustomz.App;
import ExoticCarCustomz.domain.AudioTechnician;
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
public class CrudAudioTechnicianTest {

    private Long id;

    @Autowired
    AudioTechnicianRepository repository;
    @Test
    public void testCreate() throws Exception {
        List<AudioTechnician> courses = new ArrayList<AudioTechnician>();
        AudioTechnician technician = new AudioTechnician.Builder("Scholtz").FirstName("Shannon").build();
        repository.save(technician);
        id=technician.getTechnicianID();
        Assert.assertNotNull(technician.getTechnicianID());
    }

    @Test
    public void testRead() throws Exception {
        AudioTechnician techni = repository.findOne(id);
        Assert.assertEquals("Scholtz",techni.getLastName());
    }

    @Test
    public void testUpdate() throws Exception {

        AudioTechnician techni = repository.findOne(id);
        AudioTechnician audiotechnician = new AudioTechnician.Builder("Peter")
                .technicianID(techni.getTechnicianID()).FirstName("Johannes").build();
        repository.save(audiotechnician);
        Assert.assertEquals("Peter", techni.getLastName());
        Assert.assertEquals("Johannes", techni.getFirstName());

    }

    @Test
    public void testDelete() throws Exception {
        AudioTechnician tech = repository.findOne(id);
        repository.delete(tech);
        AudioTechnician audiotech = repository.findOne(id);
        Assert.assertNull(audiotech);


    }
}
