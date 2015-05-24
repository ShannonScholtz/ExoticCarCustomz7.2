package ExoticCarCustomz.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by student on 2015/04/15.
 */

@Entity
public class Mechanic implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long mechanicID;
    private String LastName;
    private String FirstName;
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name="mechanicID")
    private List<MechanicalParts> parts;

    private Mechanic() {
    }

    public Mechanic(Builder builder) {
        mechanicID = builder.mechanicID;
        LastName = builder.LastName;
        FirstName = builder.FirstName;
        parts = builder.parts;
    }

    public Long getMechanicID() {
        return mechanicID;
    }

    public String getLastName() {
        return LastName;
    }

    public String getFirstName() {
        return FirstName;
    }

    public List<MechanicalParts> getParts() {
        return parts;
    }

    public static class Builder {

        private Long mechanicID;
        private String LastName;
        private String FirstName;
        private List<MechanicalParts> parts;

        public Builder(String LastName) {
            this.LastName = LastName;
        }

        public Builder FirstName(String FirstName) {
            this.FirstName = FirstName;
            return this;
        }

        public Builder mechanicID(Long mechanicID) {
            this.mechanicID = mechanicID;
            return this;
        }

        public Builder Parts(List<MechanicalParts> parts){
            this.parts= parts;
            return this;
        }

        public Builder copy(Mechanic value){
            this.mechanicID=value.getMechanicID();
            this.LastName=value.getLastName();
            this.FirstName=value.getFirstName();
            this.parts=value.getParts();
            return this;
        }

        public Mechanic build() {
            return new Mechanic(this);
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Mechanic)) return false;

        Mechanic mechanic = (Mechanic) o;

        return !(mechanicID != null ? !mechanicID.equals(mechanic.mechanicID) : mechanic.mechanicID != null);

    }

    @Override
    public int hashCode() {
        return mechanicID != null ? mechanicID.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Mechanic{" +
                "MechanicID = " + mechanicID +
                ", FirstName = '" + FirstName + '\'' +
                '}';
    }

}
