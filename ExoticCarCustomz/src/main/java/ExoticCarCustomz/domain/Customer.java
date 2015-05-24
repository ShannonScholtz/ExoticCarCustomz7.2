package ExoticCarCustomz.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by student on 2015/04/15.
 */

@Entity
public class Customer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long customerID;
    private String LastName;
    private String FirstName;
    private String phoneNumber;
    private String Address;


    private Customer() {
    }

    public Customer(Builder builder)
    {
        customerID = builder.customerID;
        LastName = builder.LastName;
        FirstName = builder.FirstName;
        phoneNumber = builder.phoneNumber;
        Address = builder.Address;

    }

    public String getLastName() {
        return LastName;
    }

    public Long getCustomerID() {
        return customerID;
    }

    public String getFirstName() {
        return FirstName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAddress() {
        return Address;
    }


    public static class Builder {

        private Long customerID;
        private String LastName;
        private String FirstName;
        private String phoneNumber;
        private String Address;

        public Builder(String phoneNumber)
        {
            this.phoneNumber = phoneNumber;
        }

        public Builder LastName(String LastName){
            this.LastName = LastName;
            return this;
        }

        public Builder FirstName(String FirstName){
            this.FirstName = FirstName;
            return this;
        }

        public Builder customerID(Long customerID){
            this.customerID = customerID;
            return this;
        }

        public Builder Address(String Address){
            this.Address = Address;
            return this;
        }


        public Builder copy(Customer value){
            this.customerID=value.getCustomerID();
            this.LastName=value.getLastName();
            this.FirstName=value.getFirstName();
            this.phoneNumber=value.getPhoneNumber();
            this.Address=value.getAddress();
            return this;
        }

        public Customer build(){
            return new Customer(this);
        }
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer)) return false;

        Customer customer = (Customer) o;

        return !(customerID != null ? !customerID.equals(customer.customerID) : customer.customerID != null);

    }

    @Override
    public int hashCode() {
        return customerID != null ? customerID.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "CustomerID = " + customerID +
                ", FirstName = '" + FirstName + '\'' +
                '}';
    }




}
