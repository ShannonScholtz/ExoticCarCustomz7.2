package ExoticCarCustomz.services.impl;

import ExoticCarCustomz.domain.SprayPainter;
import ExoticCarCustomz.repository.SprayPainterRepository;
import ExoticCarCustomz.services.SprayPainterServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/04/16.
 */
@Service
public class SprayPainterImpl implements SprayPainterServices {

    @Autowired
    SprayPainterRepository repository;
    public List<SprayPainter> getSprayPainters() {
        List<SprayPainter> allSprayPainter = new ArrayList<SprayPainter>();

        Iterable<SprayPainter> spray = repository.findAll();
        for (SprayPainter painter : spray) {
            allSprayPainter.add(painter);
        }
        return allSprayPainter;
    }
}
