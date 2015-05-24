package ExoticCarCustomz.services.impl;

import ExoticCarCustomz.domain.BodyParts;
import ExoticCarCustomz.repository.BodyPartsRepository;
import ExoticCarCustomz.services.BodyPartsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/04/16.
 */
@Service
public class BodyPartsImpl implements BodyPartsServices {

    @Autowired
    BodyPartsRepository repository;
    public List<BodyParts> getBodyParts() {
        List<BodyParts> allparts = new ArrayList<BodyParts>();

        Iterable<BodyParts> parts = repository.findAll();
        for (BodyParts bodyPart : parts) {
            allparts.add(bodyPart);
        }
        return allparts;
    }
}
