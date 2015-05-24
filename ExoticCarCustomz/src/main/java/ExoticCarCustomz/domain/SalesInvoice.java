package ExoticCarCustomz.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by student on 2015/04/15.
 */

@Entity
public class SalesInvoice implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long invoiceID;
    private String date;
    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name="invoiceID")
    private List<Car> car;
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name="invoiceID")
    private List<Customer> customer;
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name="invoiceID")
    private List<Salesperson> salesperson;
    private double totalPrice;

    private SalesInvoice() {
    }

    public SalesInvoice(Builder builder) {
        invoiceID = builder.invoiceID;
        date = builder.date;
        car = builder.car;
        customer = builder.customer;
        salesperson = builder.salesperson;
        totalPrice = builder.totalPrice;

    }

    public Long getInvoiceID() {
        return invoiceID;
    }

    public String getDate() {
        return date;
    }


    public List<Customer> getCustomer() {
        return customer;
    }

    public List<Salesperson> getSalesperson() {
        return salesperson;
    }

    public List<Car> getCar() {
        return car;
    }

    public double getTotalPrice(){
        return totalPrice;
    }

    public static class Builder {

        private Long invoiceID;
        private String date;
        private List<Car> car;
        private List<Customer> customer;
        private List<Salesperson> salesperson;
        private double totalPrice;

        public Builder(String date) {
            this.date = date;
        }

        public Builder Car(List<Car> value){
            this.car=value;
            return this;
        }

        public Builder customer(List<Customer> value){
            this.customer=value;
            return this;
        }


        public Builder Salesperson(List<Salesperson> value){
            this.salesperson=value;
            return this;
        }


        public Builder totalPrice(double totalPrice) {
            this.totalPrice = totalPrice;
            return this;
        }


        public Builder invoiceID(Long invoiceID) {
            this.invoiceID = invoiceID;
            return this;
        }

        public Builder copy(SalesInvoice value){
            this.invoiceID=value.getInvoiceID();
            this.date=value.getDate();
            this.car=value.car;
            this.customer=value.customer;
            this.salesperson=value.salesperson;
            this.totalPrice=value.getTotalPrice();
            return this;
        }

        public SalesInvoice build() {
            return new SalesInvoice(this);
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SalesInvoice)) return false;

        SalesInvoice salesInvoice = (SalesInvoice) o;

        return !(invoiceID != null ? !invoiceID.equals(salesInvoice.invoiceID) : salesInvoice.invoiceID != null);

    }

    @Override
    public int hashCode() {
        return invoiceID != null ? invoiceID.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "SalesInvoice{" +
                "InvoiceID = " + invoiceID +
                ", TotalPrice = '" + totalPrice + '\'' +
                '}';
    }

}
