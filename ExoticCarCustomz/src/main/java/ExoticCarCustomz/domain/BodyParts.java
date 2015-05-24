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
public class BodyParts implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long BodyPartID;
    private String BodyStylingModifications;
    private String Colour;
    private double Price;

    private BodyParts() {
    }

    public BodyParts(Builder builder) {
        BodyPartID = builder.BodyPartID;
        BodyStylingModifications = builder.BodyStylingModifications;
        Colour = builder.Colour;
        Price = builder.Price;
    }

    public Long getBodyPartID() {
        return BodyPartID;
    }

    public String getBodyStylingModifications() {
        return BodyStylingModifications;
    }

    public String getColour() {
        return Colour;
    }

    public double getPrice() {
        return Price;
    }

    public static class Builder {

        private Long BodyPartID;
        private String BodyStylingModifications;
        private String Colour;
        private double Price;

        public Builder(String BodyStylingModifications) {
            this.BodyStylingModifications = BodyStylingModifications;
        }

        public Builder Price(double Price) {
            this.Price = Price;
            return this;
        }

        public Builder Colour(String Colour) {
            this.Colour = Colour;
            return this;
        }

        public Builder BodyPartID(Long BodyPartID) {
            this.BodyPartID = BodyPartID;
            return this;
        }

        public Builder copy(BodyParts value){
            this.BodyPartID=value.getBodyPartID();
            this.BodyStylingModifications=value.getBodyStylingModifications();
            this.Colour=value.getColour();
            this.Price=value.getPrice();
            return this;
        }

        public BodyParts build() {
            return new BodyParts(this);
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Salesperson)) return false;

        BodyParts bodyParts = (BodyParts) o;

        return !(BodyPartID != null ? !BodyPartID.equals(bodyParts.BodyPartID) : bodyParts.BodyPartID != null);

    }

    @Override
    public int hashCode() {
        return BodyPartID != null ? BodyPartID.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "MechanicalParts{" +
                "BodyPartID = " + BodyPartID +
                ", BodyStylingModifications = '" + BodyStylingModifications + '\'' +
                '}';
    }
}
