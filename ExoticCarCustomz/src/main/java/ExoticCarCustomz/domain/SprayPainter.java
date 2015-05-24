package ExoticCarCustomz.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by student on 2015/04/15.
 */

@Entity
public class SprayPainter implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long painterID;
    private String LastName;
    private String FirstName;
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name="painterID")
    private List<BodyParts> bodyparts;

    private SprayPainter() {
    }

    public SprayPainter(Builder builder) {
        painterID = builder.painterID;
        LastName = builder.LastName;
        FirstName = builder.FirstName;
        bodyparts = builder.bodyparts;
    }

    public Long getPainterID() {
        return painterID;
    }

    public String getLastName() {
        return LastName;
    }

    public String getFirstName() {
        return FirstName;
    }

    public List<BodyParts> getBodyparts() {
        return bodyparts;
    }

    public static class Builder {

        private Long painterID;
        private String LastName;
        private String FirstName;
        private List<BodyParts> bodyparts;

        public Builder(String LastName) {
            this.LastName = LastName;
        }

        public Builder FirstName(String FirstName) {
            this.FirstName = FirstName;
            return this;
        }

        public Builder painterID(Long painterID) {
            this.painterID = painterID;
            return this;
        }

        public Builder BodyParts(List<BodyParts> bodyparts) {
            this.bodyparts = bodyparts;
            return this;
        }

        public Builder copy(SprayPainter value){
            this.painterID=value.getPainterID();
            this.LastName=value.getLastName();
            this.FirstName=value.getFirstName();
            this.bodyparts=value.getBodyparts();
            return this;
        }

        public SprayPainter build() {
            return new SprayPainter(this);
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SprayPainter)) return false;

        SprayPainter sprayPainter = (SprayPainter) o;

        return !(painterID != null ? !painterID.equals(sprayPainter.painterID) : sprayPainter.painterID != null);

    }

    @Override
    public int hashCode() {
        return painterID != null ? painterID.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "SprayPainter{" +
                "PainterID = " + painterID +
                ", FirstName = '" + FirstName + '\'' +
                '}';
    }


}
