package ExoticCarCustomz.services.impl;

import ExoticCarCustomz.domain.Salesperson;
import ExoticCarCustomz.repository.SalesPersonRepository;
import ExoticCarCustomz.services.SalespersonServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/04/16.
 */
@Service
public class SalespersonImpl implements SalespersonServices {

    @Autowired
    SalesPersonRepository repository;
    public List<Salesperson> getSalesperson() {
        List<Salesperson> allSalesperson = new ArrayList<Salesperson>();

        Iterable<Salesperson> sales = repository.findAll();
        for (Salesperson person : sales) {
            allSalesperson.add(person);
        }
        return allSalesperson;
    }
}
