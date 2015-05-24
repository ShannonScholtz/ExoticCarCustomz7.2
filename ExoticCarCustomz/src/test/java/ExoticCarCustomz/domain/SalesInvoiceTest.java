package ExoticCarCustomz.domain;

import ExoticCarCustomz.conf.factory.SalesInvoiceFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by student on 2015/04/16.
 */
public class SalesInvoiceTest {

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void testCreateSalesInvoice() throws Exception {
        List<Car> car = new ArrayList<Car>();
        List<Customer> customer = new ArrayList<Customer>();
        List<Salesperson> salesperson = new ArrayList<Salesperson>();

        SalesInvoice invoice = SalesInvoiceFactory
                .createSalesInvoice("05/04/2015", 13500.00, car, customer, salesperson);

        Assert.assertEquals(13500.00, invoice.getTotalPrice(), 13500.00);
        Assert.assertEquals("05/04/2015", invoice.getDate());
    }

    @Test
    public void testUpdateSalesInvoice() throws Exception {
        Map<String,String> values = new HashMap<String,String>();
        List<Car> car = new ArrayList<Car>();
        List<Customer> customer = new ArrayList<Customer>();
        List<Salesperson> salesperson = new ArrayList<Salesperson>();

        SalesInvoice invoice = SalesInvoiceFactory
                .createSalesInvoice("05/04/2015", 13500.00, car, customer, salesperson);


        SalesInvoice newcustomer = new SalesInvoice
                .Builder(invoice.getDate())
                .copy(invoice)
                .totalPrice(7000.00)
                .build();

        Assert.assertEquals(13500.00, invoice.getTotalPrice(), 13500.00);
        Assert.assertEquals(7000.00, newcustomer.getTotalPrice(), 7000.00);
    }
}
