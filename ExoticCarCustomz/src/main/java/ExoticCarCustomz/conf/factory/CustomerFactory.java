package ExoticCarCustomz.conf.factory;

import ExoticCarCustomz.domain.Customer;

import java.util.Map;

/**
 * Created by student on 2015/04/23.
 */
public class CustomerFactory {

    public static Customer createCustomer(String phoneNumber, String LastName, String FirstName, String Address) {
        Customer customer = new Customer
                .Builder(phoneNumber)
                .LastName(LastName)
                .FirstName(FirstName)
                .Address(Address)
                .build();
        return customer;
    }
}
