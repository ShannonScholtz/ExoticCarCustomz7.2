package ExoticCarCustomz.conf.factory;

import ExoticCarCustomz.domain.AudioEquipment;

import java.util.List;
import java.util.Map;

/**
 * Created by student on 2015/04/23.
 */
public class AudioEquipmentFactory {

    public static AudioEquipment createAudioEquipment(double Price,
                                      String description) {
        AudioEquipment equipment = new AudioEquipment
                .Builder(description)
                .Price(Price)
                .build();
        return equipment;
    }
}
