package ExoticCarCustomz.domain;

import ExoticCarCustomz.conf.factory.CustomerFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by student on 2015/04/16.
 */
public class CustomerTest {

    @Before
    public void setUp() throws Exception {


    }

    @Test
    public void testCreateCustomer() throws Exception {
        Customer customer = CustomerFactory
                .createCustomer("0832342948", "Zeeman", "Lemi", "Northpine Kraaifontein 5 clapper street");

        Assert.assertEquals("0832342948", customer.getPhoneNumber());
        Assert.assertEquals("Lemi", customer.getFirstName());
        Assert.assertEquals("Zeeman", customer.getLastName());
        Assert.assertEquals("Northpine Kraaifontein 5 clapper street", customer.getAddress());
    }

    @Test
    public void testUpdateCustomer() throws Exception {
        Customer customer = CustomerFactory
                .createCustomer("0832342948", "Zeeman", "Lemi", "Northpine Kraaifontein 5 clapper street");

        Customer newaddress = new Customer
                .Builder(customer.getPhoneNumber())
                .copy(customer)
                .LastName(customer.getLastName())
                .FirstName(customer.getFirstName())
                .Address("Paarl 60 farm street")
                .build();


        Assert.assertEquals("0832342948", newaddress.getPhoneNumber());
        Assert.assertEquals("Lemi", newaddress.getFirstName());
        Assert.assertEquals("Zeeman", newaddress.getLastName());
        Assert.assertEquals("Northpine Kraaifontein 5 clapper street", customer.getAddress());
        Assert.assertEquals("Paarl 60 farm street", newaddress.getAddress());

    }
}
