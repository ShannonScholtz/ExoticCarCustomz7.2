package ExoticCarCustomz.services.impl;

import ExoticCarCustomz.domain.Car;
import ExoticCarCustomz.domain.Customer;
import ExoticCarCustomz.domain.SalesInvoice;
import ExoticCarCustomz.domain.Salesperson;
import ExoticCarCustomz.repository.SalesInvoiceRepository;
import ExoticCarCustomz.services.SalesInvoiceServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/04/16.
 */
@Service
public class SalesInvoiceImpl implements SalesInvoiceServices {

    @Autowired
    SalesInvoiceRepository repository;

    @Override
    public List<SalesInvoice> getSalesInvoice() {
        List<SalesInvoice> allsalesinvoice = new ArrayList<SalesInvoice>();

        Iterable<SalesInvoice> salesinvoice = repository.findAll();
        for (SalesInvoice invoice : salesinvoice) {
            allsalesinvoice.add(invoice);
        }
        return allsalesinvoice;
    }

    @Override
    public List<Car> getCars(Long id) {
        return repository.findOne(id).getCar();
    }

    @Override
    public List<Customer> getCustomers(Long id){
        return repository.findOne(id).getCustomer();
    }


    @Override
    public List<Salesperson> getSalespersons(Long id){
        return repository.findOne(id).getSalesperson();
    }

}

