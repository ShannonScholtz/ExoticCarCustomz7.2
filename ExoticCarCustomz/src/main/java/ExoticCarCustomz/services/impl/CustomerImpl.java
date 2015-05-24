package ExoticCarCustomz.services.impl;

import ExoticCarCustomz.domain.Customer;
import ExoticCarCustomz.repository.CustomerRepository;
import ExoticCarCustomz.services.CustomerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/04/16.
 */
@Service
public class CustomerImpl implements CustomerServices {

    @Autowired
    CustomerRepository repository;
    public List<Customer> getCustomer() {
        List<Customer> allcust = new ArrayList<Customer>();

        Iterable<Customer> custom = repository.findAll();
        for (Customer customers : custom) {
            allcust.add(customers);
        }
        return allcust;
    }
}
