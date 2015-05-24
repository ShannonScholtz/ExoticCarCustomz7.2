package ExoticCarCustomz.services.impl;

import ExoticCarCustomz.domain.AudioTechnician;
import ExoticCarCustomz.repository.AudioTechnicianRepository;
import ExoticCarCustomz.services.AudioTechnicianServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/04/16.
 */
@Service
public class AudioTechnicianImpl implements AudioTechnicianServices {

    @Autowired
    AudioTechnicianRepository repository;
    public List<AudioTechnician> getAudioTechnician() {
        List<AudioTechnician> allTechnician = new ArrayList<AudioTechnician>();

        Iterable<AudioTechnician> audioTechnician = repository.findAll();
        for (AudioTechnician audioEquip : audioTechnician) {
            allTechnician.add(audioEquip);
        }
        return allTechnician;
    }
}
