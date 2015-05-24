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
public class Salesperson implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long salespersonID;
    private String LastName;
    private String FirstName;

    private Salesperson() {
    }

    public Salesperson(Builder builder) {
        salespersonID = builder.salespersonID;
        LastName = builder.LastName;
        FirstName = builder.FirstName;
    }

    public Long getSalespersonID() {
        return salespersonID;
    }

    public String getLastName() {
        return LastName;
    }

    public String getFirstName() {
        return FirstName;
    }

    public static class Builder {

        private Long salespersonID;
        private String LastName;
        private String FirstName;

        public Builder(String LastName) {
            this.LastName = LastName;
        }

        public Builder FirstName(String FirstName) {
            this.FirstName = FirstName;
            return this;
        }

        public Builder salespersonID(Long salespersonID) {
            this.salespersonID = salespersonID;
            return this;
        }

        public Builder copy(Salesperson value){
            this.salespersonID=value.getSalespersonID();
            this.LastName=value.getLastName();
            this.FirstName=value.getFirstName();
            return this;
        }

        public Salesperson build() {
            return new Salesperson(this);
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Salesperson)) return false;

        Salesperson salesperson = (Salesperson) o;

        return !(salespersonID != null ? !salespersonID.equals(salesperson.salespersonID) : salesperson.salespersonID != null);

    }

    @Override
    public int hashCode() {
        return salespersonID != null ? salespersonID.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Salesperson{" +
                "SalespersonID = " + salespersonID +
                ", FirstName = '" + FirstName + '\'' +
                '}';
    }

}
