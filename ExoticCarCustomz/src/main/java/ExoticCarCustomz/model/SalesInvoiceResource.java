package ExoticCarCustomz.model;

import java.util.List;

import ExoticCarCustomz.domain.Car;
import ExoticCarCustomz.domain.Customer;
import ExoticCarCustomz.domain.SalesInvoice;
import ExoticCarCustomz.domain.Salesperson;
import org.springframework.hateoas.ResourceSupport;
/**
 * Created by student on 2015/05/24.
 */
public class SalesInvoiceResource extends ResourceSupport {


    private Long reinvoiceID;
    private String date;
    private List<Car> car;
    private List<Customer> customer;
    private List<Salesperson> salesperson;
    private double totalPrice;

    private SalesInvoiceResource() {
    }

    public SalesInvoiceResource(Builder builder) {
        reinvoiceID = builder.reinvoiceID;
        date = builder.date;
        car = builder.car;
        customer = builder.customer;
        salesperson = builder.salesperson;
        totalPrice = builder.totalPrice;

    }

    public Long getReinvoiceID() {
        return reinvoiceID;
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

        private Long reinvoiceID;
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


        public Builder ReinvoiceID(Long reinvoiceID) {
            this.reinvoiceID = reinvoiceID;
            return this;
        }

        public Builder copy(SalesInvoiceResource value){
            this.reinvoiceID=value.getReinvoiceID();
            this.date=value.getDate();
            this.car=value.car;
            this.customer=value.customer;
            this.salesperson=value.salesperson;
            this.totalPrice=value.getTotalPrice();
            return this;
        }

        public SalesInvoiceResource build() {
            return new SalesInvoiceResource(this);
        }

    }
}
