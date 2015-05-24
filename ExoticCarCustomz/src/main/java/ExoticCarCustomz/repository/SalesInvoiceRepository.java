package ExoticCarCustomz.repository;

import ExoticCarCustomz.domain.SalesInvoice;
import org.springframework.data.repository.CrudRepository;


/**
 * Created by student on 2015/04/15.
 */
public interface SalesInvoiceRepository extends CrudRepository<SalesInvoice, Long>{

    public SalesInvoice findbysalespersonID(long salespersonID);
}
