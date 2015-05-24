package ExoticCarCustomz.conf.factory;

import ExoticCarCustomz.domain.MechanicalParts;

import java.util.Map;

/**
 * Created by student on 2015/04/23.
 */
public class MechanicalPartsFactory {

    public static MechanicalParts createMechanicalParts(double Price,
                                                        String description) {
        MechanicalParts parts = new MechanicalParts
                .Builder(description)
                .Price(Price)
                .build();
        return parts;
    }
}
