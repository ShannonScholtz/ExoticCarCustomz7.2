package ExoticCarCustomz.services;

import ExoticCarCustomz.App;
import ExoticCarCustomz.conf.factory.CarFactory;
import ExoticCarCustomz.conf.factory.CustomerFactory;
import ExoticCarCustomz.conf.factory.SalesInvoiceFactory;
import ExoticCarCustomz.conf.factory.SalespersonFactory;
import ExoticCarCustomz.domain.Car;
import ExoticCarCustomz.domain.Customer;
import ExoticCarCustomz.domain.SalesInvoice;
import ExoticCarCustomz.domain.Salesperson;
import ExoticCarCustomz.repository.SalesInvoiceRepository;
import org.junit.Assert;
//import org.testng.annotations.BeforeMethod;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/05/10.
 *
 *  */
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class TestSalesInvoiceServices extends AbstractTestNGSpringContextTests {
    @Autowired
    private SalesInvoiceServices service;

    private Long id;

    @Autowired
    private SalesInvoiceRepository repository;
    private List<Car> car;
    private List<Customer> customer;
    private List<Salesperson> salesperson;

    @Before
    public void setUp() throws Exception {
        car = new ArrayList<Car>();
        customer = new ArrayList<Customer>();
        salesperson = new ArrayList<Salesperson>();
    }

    @Test
    public void create() throws Exception {

        Car car1 = CarFactory
                .createCar("20150607GTI7", "Volkswagen", "Golf 7 GTI", "Lime", "2015");

        Customer customer1 = CustomerFactory
                .createCustomer("0832342948", "Zeeman", "Lemi", "Northpine Kraaifontein 5 clapper street");

        Salesperson salesperson1 = SalespersonFactory
                .createSalesperson("Johnson" , "Peter");

        car.add(car1);
        customer.add(customer1);
        salesperson.add(salesperson1);

        SalesInvoice salesInvoice = SalesInvoiceFactory
                .createSalesInvoice("18/05/2015" , 10699.00, car, customer, salesperson);

        repository.save(salesInvoice);
        id= salesInvoice.getInvoiceID();
        Assert.assertNotNull(salesInvoice.getInvoiceID());
    }

    @Test
    public void testGetSaleInvoiceCar() throws Exception {
        List<Car> cars = service.getCars(id);
        Assert.assertTrue(cars.size() == 1);
    }

    @Test
    public void testGetSaleInvoiceCustomer() throws Exception {
        List<Customer> customers = service.getCustomers(id);
        Assert.assertTrue(customers.size() == 1);
    }

    @Test
    public void testGetSaleInvoiceSalesperson() throws Exception {
        List<Salesperson> salespersons = service.getSalespersons(id);
        Assert.assertTrue(salespersons.size() == 1);
    }
}

