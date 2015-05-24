package ExoticCarCustomz.repository;

import ExoticCarCustomz.domain.AudioTechnician;
import org.springframework.data.repository.CrudRepository;


/**
 * Created by student on 2015/04/15.
 */
public interface AudioTechnicianRepository extends CrudRepository<AudioTechnician, Long> {

    public AudioTechnician findbyLastName(String LastName);
}
