package ExoticCarCustomz.conf.factory;

import ExoticCarCustomz.domain.Car;
import ExoticCarCustomz.domain.Customer;
import ExoticCarCustomz.domain.SalesInvoice;
import ExoticCarCustomz.domain.Salesperson;

import java.util.List;
import java.util.Map;

/**
 * Created by student on 2015/04/23.
 */
public class SalesInvoiceFactory {


    public static SalesInvoice createSalesInvoice(String date, double totalPrice, List<Car> car,
                                                   List<Customer> customer,List<Salesperson> salesperson) {
        SalesInvoice invoice = new SalesInvoice
                .Builder(date)
                .customer(customer)
                .Car(car)
                .Salesperson(salesperson)
                .totalPrice(totalPrice)
                .build();
        return invoice;
    }
}
