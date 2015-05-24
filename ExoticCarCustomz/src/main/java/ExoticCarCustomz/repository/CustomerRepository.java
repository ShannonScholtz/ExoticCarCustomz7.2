package ExoticCarCustomz.repository;

import ExoticCarCustomz.domain.Customer;
import org.springframework.data.repository.CrudRepository;


/**
 * Created by student on 2015/04/15.
 */
public interface CustomerRepository extends CrudRepository<Customer, Long> {

    public Customer findbyphoneNumber(String phoneNumber);
}
