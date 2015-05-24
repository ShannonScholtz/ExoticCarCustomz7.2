package ExoticCarCustomz.conf.factory;

import ExoticCarCustomz.domain.BodyParts;
import ExoticCarCustomz.domain.SprayPainter;

import java.util.List;
import java.util.Map;

/**
 * Created by student on 2015/04/23.
 */
public class SprayPainterFactory {

    public static SprayPainter createSprayPainter(String LastName,String FirstName, List<BodyParts> bodyparts) {
        SprayPainter painter = new SprayPainter
                .Builder(LastName)
                .FirstName(FirstName)
                .BodyParts(bodyparts)
                .build();
        return painter;
    }
}
