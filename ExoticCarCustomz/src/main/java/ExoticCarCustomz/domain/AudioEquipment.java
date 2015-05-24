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
public class AudioEquipment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long AudioEquipmentID;
    private String description;
    private double Price;


    private AudioEquipment() {
    }

    public AudioEquipment(Builder builder) {
        AudioEquipmentID = builder.AudioEquipmentID;
        description = builder.description;
        Price = builder.Price;
    }

    public Long getAudioEquipmentID() {
        return AudioEquipmentID;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return Price;
    }

    public static class Builder {

        private Long AudioEquipmentID;
        private String description;
        private double Price;

        public Builder(String description) {
            this.description = description;
        }

        public Builder Price(double Price) {
            this.Price = Price;
            return this;
        }

        public Builder AudioEquipmentID(Long AudioEquipmentID) {
            this.AudioEquipmentID = AudioEquipmentID;
            return this;
        }

        public Builder copy(AudioEquipment value){
            this.AudioEquipmentID=value.getAudioEquipmentID();
            this.description=value.getDescription();
            this.Price=value.getPrice();
            return this;
        }


        public AudioEquipment build() {
            return new AudioEquipment(this);
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Salesperson)) return false;

        AudioEquipment audioEquipment = (AudioEquipment) o;

        return !(AudioEquipmentID != null ? !AudioEquipmentID.equals(audioEquipment.AudioEquipmentID) : audioEquipment.AudioEquipmentID != null);

    }

    @Override
    public int hashCode() {
        return AudioEquipmentID != null ? AudioEquipmentID.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "AudioEquipment{" +
                "AudioEquipmentID = " + AudioEquipmentID +
                ", Description = '" + description + '\'' +
                '}';
    }
}
