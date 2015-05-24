package ExoticCarCustomz.repository;

import ExoticCarCustomz.domain.Mechanic;
import org.springframework.data.repository.CrudRepository;


/**
 * Created by student on 2015/04/15.
 */
public interface MechanicRepository extends CrudRepository<Mechanic, Long> {

    public Mechanic findbyLastName(String LastName);
}
