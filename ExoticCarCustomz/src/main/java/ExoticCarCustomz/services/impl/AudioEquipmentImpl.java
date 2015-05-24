package ExoticCarCustomz.services.impl;

import ExoticCarCustomz.domain.AudioEquipment;
import ExoticCarCustomz.repository.AudioEquipmentRepository;
import ExoticCarCustomz.services.AudioEquipmentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/04/16.
 */
@Service
public class AudioEquipmentImpl implements AudioEquipmentServices {

    @Autowired
    AudioEquipmentRepository repository;
    public List<AudioEquipment> getAudioEquipment() {
        List<AudioEquipment> allequipment = new ArrayList<AudioEquipment>();

        Iterable<AudioEquipment> audioEquipment = repository.findAll();
        for (AudioEquipment audioEquip : audioEquipment) {
            allequipment.add(audioEquip);
        }
        return allequipment;
    }
}
