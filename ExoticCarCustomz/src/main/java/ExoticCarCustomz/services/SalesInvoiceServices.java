package ExoticCarCustomz.services;


import ExoticCarCustomz.domain.Car;
import ExoticCarCustomz.domain.Customer;
import ExoticCarCustomz.domain.SalesInvoice;
import ExoticCarCustomz.domain.Salesperson;

import java.util.List;

/**
 * Created by student on 2015/04/16.
 */
public interface SalesInvoiceServices {

    List<SalesInvoice> getAllSalesInvoice();
    List<Car> getCars(Long id);
    List<Customer> getCustomers(Long id);
    List<Salesperson> getSalespersons(Long id);

}


