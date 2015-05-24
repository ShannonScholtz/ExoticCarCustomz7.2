package ExoticCarCustomz.domain;

import ExoticCarCustomz.conf.factory.BodyPartsFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by student on 2015/04/16.
 */
public class BodyPartsTest {

    @Before
    public void setUp() throws Exception {


    }

    @Test
    public void testCreateBodyParts() throws Exception {

        BodyParts equipment = BodyPartsFactory
                .createBodyParts(13599.99, "Sun-roof", "White");

        Assert.assertEquals("Sun-roof", equipment.getBodyStylingModifications());
        Assert.assertEquals("White", equipment.getColour());
        Assert.assertEquals(13599.99, equipment.getPrice(), 13599.99);
    }

    @Test
    public void testUpdateBodyParts() throws Exception {

        BodyParts equipment = BodyPartsFactory
                .createBodyParts(13599.99, "Sun-roof", "White");

        BodyParts newprice = new BodyParts
        .Builder(equipment.getBodyStylingModifications())
                .copy(equipment)
                .Price(15599.99)
                .build();

        Assert.assertEquals("Sun-roof", newprice.getBodyStylingModifications());
        Assert.assertEquals(15599.99, newprice.getPrice(), 15599.99 );
        Assert.assertEquals(13599.99, equipment.getPrice(), 13599.99);


    }
}
