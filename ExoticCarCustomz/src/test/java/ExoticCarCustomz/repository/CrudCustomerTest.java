package ExoticCarCustomz.repository;

import ExoticCarCustomz.App;
import ExoticCarCustomz.domain.Customer;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/04/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class CrudCustomerTest {

    private Long id;

    @Autowired
    CustomerRepository repository;
    @Test
    public void testCreate() throws Exception {
        List<Customer> cus = new ArrayList<Customer>();
        Customer cust = new Customer.Builder("0612323276").LastName("Simons")
                .FirstName("Edmund").Address("5 Petersburg drive Chicago").build();
        repository.save(cust);
        id = cust.getCustomerID();
        Assert.assertNotNull(cust.getCustomerID());
    }

    @Test
    public void testRead() throws Exception {
        Customer cust = repository.findOne(id);
        Assert.assertEquals("5 Petersburg drive Chicago",cust.getAddress());
    }

    @Test
    public void testUpdate() throws Exception {

        Customer cus = repository.findOne(id);
        Customer custom = new Customer.Builder("0612325677")
                .customerID(cus.getCustomerID()).LastName("Simons")
                .FirstName("Beatrix").Address("5 Petersburg drive Chicago").build();
        repository.save(custom);
        Assert.assertEquals("0612325677", cus.getPhoneNumber());
        Assert.assertEquals("Simons", cus.getLastName());
        Assert.assertEquals("Beatrix", cus.getFirstName());
        Assert.assertEquals("5 Petersburg drive Chicago", cus.getAddress());

    }

    @Test
    public void testDelete() throws Exception {
        Customer cus = repository.findOne(id);
        repository.delete(cus);
        Customer cust = repository.findOne(id);
        Assert.assertNull(cust);


    }
}
