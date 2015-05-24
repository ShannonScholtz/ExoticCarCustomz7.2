package ExoticCarCustomz.services.impl;

import ExoticCarCustomz.domain.Mechanic;
import ExoticCarCustomz.repository.MechanicRepository;
import ExoticCarCustomz.services.MechanicServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/04/16.
 */
@Service
public class MechanicImpl implements MechanicServices {

    @Autowired
    MechanicRepository repository;
    public List<Mechanic> getMechanic() {
        List<Mechanic> allmechanics = new ArrayList<Mechanic>();

        Iterable<Mechanic> mechanics = repository.findAll();
        for (Mechanic mech : mechanics) {
            allmechanics.add(mech);
        }
        return allmechanics;
    }
}
