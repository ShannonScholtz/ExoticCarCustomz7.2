package ExoticCarCustomz.conf.factory;

import ExoticCarCustomz.domain.Mechanic;
import ExoticCarCustomz.domain.MechanicalParts;

import java.util.List;


/**
 * Created by student on 2015/04/23.
 */
public class MechanicFactory {

    public static Mechanic createMechanic(String LastName, String FirstName, List<MechanicalParts> parts) {
        Mechanic mechanic = new Mechanic
                .Builder(LastName)
                .FirstName(FirstName)
                .Parts(parts)
                .build();
        return mechanic;
    }
}
