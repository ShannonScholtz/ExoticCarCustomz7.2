package ExoticCarCustomz.repository;

import ExoticCarCustomz.domain.Salesperson;
import org.springframework.data.repository.CrudRepository;


/**
 * Created by student on 2015/04/15.
 */
public interface SalesPersonRepository extends CrudRepository<Salesperson,Long>{

    public Salesperson findByLastName(String LastName);
}
