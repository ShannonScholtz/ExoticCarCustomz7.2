package ExoticCarCustomz.repository;


import ExoticCarCustomz.App;
import ExoticCarCustomz.conf.factory.AudioEquipmentFactory;
import ExoticCarCustomz.domain.AudioEquipment;
import org.junit.Assert;
import org.junit.Test;
//import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
//import org.testng.Assert;
//import org.testng.annotations.Test;


/**
 * Created by student on 2015/04/16.
 */
//@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class CrudAudioEquipmentTest extends AbstractTestNGSpringContextTests{

    private Long id;

    @Autowired
    AudioEquipmentRepository repository;

    @Test
    public void create() throws Exception {
        AudioEquipment audio = AudioEquipmentFactory
                .createAudioEquipment(2700.00, "Amplifier");

        repository.save(audio);
        id=audio.getAudioEquipmentID();
        Assert.assertNotNull(audio.getAudioEquipmentID());

    }

    @Test//(dependsOnMethods = "create")
    public void read() throws Exception {
        AudioEquipment  audioEquip = repository.findOne(id);
        Assert.assertEquals("Amplifier", audioEquip.getDescription());
    }

    @Test//(dependsOnMethods = "read")
    public void update() throws Exception {
        AudioEquipment audio = repository.findOne(id);
        AudioEquipment equip = new AudioEquipment
                .Builder("12\" Subwoofer")
                .AudioEquipmentID(audio.getAudioEquipmentID())
                .Price(1500.00)
                .build();

        repository.save(equip);

        AudioEquipment updatedaudio = repository.findOne(id);

        Assert.assertEquals("12\" Subwoofer", updatedaudio.getDescription());
        Assert.assertEquals(1500.00, updatedaudio.getPrice(), 1500.00);
    }

    @Test//(dependsOnMethods = "update")
    public void delete() throws Exception{
        AudioEquipment audioEquipment = repository.findOne(id);
        repository.delete(audioEquipment);
        AudioEquipment audioE = repository.findOne(id);
        Assert.assertNull(audioE);
    }

}
