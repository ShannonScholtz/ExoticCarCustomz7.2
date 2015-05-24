package ExoticCarCustomz.repository;

import ExoticCarCustomz.domain.MechanicalParts;
import org.springframework.data.repository.CrudRepository;


/**
 * Created by student on 2015/04/15.
 */
public interface MechanicalPartsRepository extends CrudRepository<MechanicalParts, Long>{

    public MechanicalParts findbydescription(String description);
}
