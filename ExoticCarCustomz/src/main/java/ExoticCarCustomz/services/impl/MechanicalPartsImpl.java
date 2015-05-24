package ExoticCarCustomz.services.impl;

import ExoticCarCustomz.domain.MechanicalParts;
import ExoticCarCustomz.repository.MechanicalPartsRepository;
import ExoticCarCustomz.services.MechanicalPartsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/04/16.
 */
@Service
public class MechanicalPartsImpl implements MechanicalPartsServices {

    @Autowired
    MechanicalPartsRepository repository;
    public List<MechanicalParts> getMechanicalParts() {
        List<MechanicalParts> allMechanicalParts = new ArrayList<MechanicalParts>();

        Iterable<MechanicalParts> mechanical = repository.findAll();
        for (MechanicalParts mec : mechanical) {
            allMechanicalParts.add(mec);
        }
        return allMechanicalParts;
    }
}
