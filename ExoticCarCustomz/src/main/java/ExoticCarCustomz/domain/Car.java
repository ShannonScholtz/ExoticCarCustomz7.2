package ExoticCarCustomz.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by student on 2015/04/15.
 */
@Entity
public class Car implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long carID;
    @Column(unique = true)
    private String serialNumber;
    private String make;
    private String model;
    private String colour;
    private String year;

    private Car(){
    }

    public Car(Builder builder) {

        carID = builder.carID;
        serialNumber = builder.serialNumber;
        make = builder.make;
        model = builder.model;
        colour = builder.colour;
        year = builder.year;
    }


    public String getSerialNumber() {
        return serialNumber;
    }

    public Long getCarID() {
        return carID;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public String getColour() {
        return colour;
    }

    public String getYear() {
        return year;
    }

    public static class Builder{

        private Long carID;
        private String serialNumber;
        private String make;
        private String model;
        private String colour;
        private String year;

        public Builder(String serialNumber) {
            this.serialNumber = serialNumber;
        }

        public Builder carID(Long carID) {
            this.carID = carID;
            return this;
        }

        public Builder make(String make) {
            this.make = make;
            return this;
        }

        public Builder model(String model) {
            this.model = model;
            return this;
        }

        public Builder colour(String colour) {
            this.colour = colour;
            return this;
        }

        public Builder year(String year) {
            this.year = year;
            return this;
        }

        public Builder copy(Car value){
            this.carID=value.getCarID();
            this.serialNumber=value.getSerialNumber();
            this.make=value.getMake();
            this.model=value.getModel();
            this.colour=value.getColour();
            this.year=value.getYear();
            return this;
        }

        public Car build(){
            return new Car(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Salesperson)) return false;

        Car car = (Car) o;

        return !(carID != null ? !carID.equals(car.carID) : car.carID != null);

    }

    @Override
    public int hashCode() {
        return carID != null ? carID.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Car{" +
                "CarID = " + carID +
                ", SerialNumber = '" + serialNumber + '\'' +
                '}';
    }

}
