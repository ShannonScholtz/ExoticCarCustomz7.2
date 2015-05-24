package ExoticCarCustomz.repository;

import ExoticCarCustomz.domain.AudioEquipment;
import org.springframework.data.repository.CrudRepository;


/**
 * Created by student on 2015/04/15.
 */
public interface AudioEquipmentRepository extends CrudRepository<AudioEquipment, Long> {

    public AudioEquipment findbydescription(String description);
}