package ExoticCarCustomz.conf.factory;

import ExoticCarCustomz.domain.AudioEquipment;
import ExoticCarCustomz.domain.AudioTechnician;

import java.util.List;
import java.util.Map;

/**
 * Created by student on 2015/04/23.
 */
public class AudioTechnicianFactory {

    public static AudioTechnician createAudioTechnician(Map<String,String> values, List<AudioEquipment> audio) {
        AudioTechnician technician = new AudioTechnician
                .Builder(values.get("LastName"))
                .FirstName(values.get("FirstName"))
                .Audio(audio)
                .build();
        return technician;
    }
}
