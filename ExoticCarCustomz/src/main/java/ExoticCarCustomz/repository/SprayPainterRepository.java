package ExoticCarCustomz.repository;

import ExoticCarCustomz.domain.SprayPainter;
import org.springframework.data.repository.CrudRepository;


/**
 * Created by student on 2015/04/15.
 */
public interface SprayPainterRepository extends CrudRepository<SprayPainter, Long>{

    public SprayPainter findByLastName(String LastName);
}
