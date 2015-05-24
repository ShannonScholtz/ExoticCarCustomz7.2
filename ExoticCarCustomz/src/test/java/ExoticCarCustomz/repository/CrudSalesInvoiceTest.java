package ExoticCarCustomz.repository;

import ExoticCarCustomz.App;
import ExoticCarCustomz.domain.SalesInvoice;
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
public class CrudSalesInvoiceTest {

    private Long id;

    @Autowired
    SalesInvoiceRepository repository;
    @Test
    public void testCreate() throws Exception {
        List<SalesInvoice> inv = new ArrayList<SalesInvoice>();
        SalesInvoice invoice = new SalesInvoice.Builder("05/05/2015")
               .totalPrice(12599.99).build();
        repository.save(invoice);
        id= invoice.getInvoiceID();
        Assert.assertNotNull(invoice.getInvoiceID());
    }

    @Test
    public void testRead() throws Exception {
        SalesInvoice salesin = repository.findOne(id);
        Assert.assertEquals("05/05/2015",salesin.getDate());
    }

    @Test
    public void testUpdate() throws Exception {

        SalesInvoice salesInvoice = repository.findOne(id);
        SalesInvoice sales = new SalesInvoice.Builder("20/05/2015").invoiceID(salesInvoice.getInvoiceID())
                .totalPrice(10000.00).build();
        repository.save(sales);
        Assert.assertEquals("20/05/2015", salesInvoice.getDate());
        Assert.assertEquals(10000.00, salesInvoice.getTotalPrice(), 10000.00);


    }

    @Test
    public void testDelete() throws Exception {
        SalesInvoice salesInvoice = repository.findOne(id);
        repository.delete(salesInvoice);
        SalesInvoice sal = repository.findOne(id);
        Assert.assertNull(sal);


    }
}
