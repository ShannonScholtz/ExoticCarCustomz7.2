package ExoticCarCustomz.domain;

import ExoticCarCustomz.conf.factory.AudioEquipmentFactory;
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
public class AudioEquipmentTest {

    @Before
    public void setUp() throws Exception {


    }

    @Test
    public void testCreateAudioEquipment() throws Exception {

        AudioEquipment equipment = AudioEquipmentFactory
                .createAudioEquipment(599.99, "Limited edition Sony Xplode 6x9's");

        Assert.assertEquals("Limited edition Sony Xplode 6x9's", equipment.getDescription());
    }

    @Test
    public void testUpdateAudioEquipment() throws Exception {

        AudioEquipment equipment = AudioEquipmentFactory
                .createAudioEquipment(599.99, "Limited edition Sony Xplode 6x9's");

        AudioEquipment newprice = new AudioEquipment
                .Builder(equipment.getDescription())
                .copy(equipment)
                .Price(600.00)
                .build();

        Assert.assertEquals("Limited edition Sony Xplode 6x9's", newprice.getDescription());
        Assert.assertEquals(600.00, newprice.getPrice(), 600.00 );
        Assert.assertEquals(599.99, equipment.getPrice(), 599.99);


    }
}
