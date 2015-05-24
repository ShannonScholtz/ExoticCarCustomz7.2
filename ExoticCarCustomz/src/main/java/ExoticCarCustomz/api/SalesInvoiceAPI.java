package ExoticCarCustomz.api;

import ExoticCarCustomz.domain.Car;
import ExoticCarCustomz.domain.Customer;
import ExoticCarCustomz.domain.SalesInvoice;
import ExoticCarCustomz.domain.Salesperson;
import ExoticCarCustomz.model.SalesInvoiceResource;
import ExoticCarCustomz.services.SalesInvoiceServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.hateoas.Link;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/05/24.
 */

@RestController
@RequestMapping(value="/SaleInvoice/**")
public class SalesInvoiceAPI {

    @Autowired
    private SalesInvoiceServices service;
    @RequestMapping(value="/{id}", method= RequestMethod.GET)
    public List<Car> getCarInvoices(@PathVariable Long id) {
        return service.getCars(id);
    }

    @RequestMapping(value="/{id}", method= RequestMethod.GET)
    public List<Customer> getCust(@PathVariable Long id) {
        return service.getCustomers(id);
    }

    @RequestMapping(value="/{id}", method= RequestMethod.GET)
    public List<Salesperson> getSalesperson(@PathVariable Long id) {
        return service.getSalespersons(id);
    }

    @RequestMapping(value="/SalesInvoices", method=RequestMethod.GET)
    public List<SalesInvoiceResource> getSalesInvoices() {
        List<SalesInvoiceResource> hateos = new ArrayList();
        List<SalesInvoice> sales = service.getAllSalesInvoice();
        for (SalesInvoice invoice : sales) {
            SalesInvoiceResource res = new SalesInvoiceResource
                    .Builder(invoice.getDate())
                    .Car(invoice.getCar())
                    .customer(invoice.getCustomer())
                    .Salesperson(invoice.getSalesperson())
                    .totalPrice(invoice.getTotalPrice())
                    .ReinvoiceID(invoice.getInvoiceID())
                    .build();
            Link cars = new
                    Link("http://localhost:8080/SalesInvoice/"+res.getReinvoiceID().toString())
                    .withRel("depts");
            res.add(cars);
            Link customers = new
                    Link("http://localhost:8080/SalesInvoice/"+res.getReinvoiceID().toString())
                    .withRel("depts");
            res.add(customers);
            Link salespersons = new
                    Link("http://localhost:8080/SalesInvoice/"+res.getReinvoiceID().toString())
                    .withRel("depts");
            res.add(salespersons);

            hateos.add(res);

        }
        return hateos;
    }

}
