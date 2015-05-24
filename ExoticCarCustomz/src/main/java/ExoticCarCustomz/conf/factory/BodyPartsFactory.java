package ExoticCarCustomz.conf.factory;

import ExoticCarCustomz.domain.BodyParts;

import java.util.Map;

/**
 * Created by student on 2015/04/23.
 */
public class BodyPartsFactory {

   public static BodyParts createBodyParts(double Price, String BodyStylingModifications,String Colour) {
        BodyParts parts = new BodyParts
                .Builder(BodyStylingModifications)
                .Colour(Colour)
                .Price(Price)
                .build();
        return parts;
    }
}
