package ExoticCarCustomz.domain;


import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by student on 2015/04/15.
 */
public class MechanicalParts implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long mechanicalPartID;
    private String description;
    private double Price;

    private MechanicalParts() {
    }

    public MechanicalParts(Builder builder) {
        mechanicalPartID = builder.mechanicalPartID;
        description = builder.description;
        Price = builder.Price;
    }

    public Long getMechanicalPartID() {
        return mechanicalPartID;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return Price;
    }

    public static class Builder {

        private Long mechanicalPartID;
        private String description;
        private double Price;

        public Builder(String description) {
            this.description = description;
        }

        public Builder Price(double Price) {
            this.Price = Price;
            return this;
        }

        public Builder mechanicalPartID(Long mechanicalPartID) {
            this.mechanicalPartID = mechanicalPartID;
            return this;
        }

        public Builder copy(MechanicalParts value){
            this.mechanicalPartID=value.getMechanicalPartID();
            this.description=value.getDescription();
            this.Price=value.getPrice();
            return this;
        }

        public MechanicalParts build() {
            return new MechanicalParts(this);
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Salesperson)) return false;

        MechanicalParts mechanicalParts = (MechanicalParts) o;

        return !(mechanicalPartID != null ? !mechanicalPartID.equals(mechanicalParts.mechanicalPartID) : mechanicalParts.mechanicalPartID != null);

    }

    @Override
    public int hashCode() {
        return mechanicalPartID != null ? mechanicalPartID.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "MechanicalParts{" +
                "MechanicalPartID = " + mechanicalPartID +
                ", Description = '" + description + '\'' +
                '}';
    }
}
