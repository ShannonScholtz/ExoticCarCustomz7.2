package ExoticCarCustomz.repository;

import ExoticCarCustomz.domain.BodyParts;
import org.springframework.data.repository.CrudRepository;


/**
 * Created by student on 2015/04/15.
 */
public interface BodyPartsRepository extends CrudRepository<BodyParts, Long> {

    public BodyParts findbyBodyStylingModifications(String BodyStylingModifications);
}
