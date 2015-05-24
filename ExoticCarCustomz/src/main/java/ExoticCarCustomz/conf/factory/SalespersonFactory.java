package ExoticCarCustomz.conf.factory;

import ExoticCarCustomz.domain.Salesperson;

import java.util.Map;

/**
 * Created by student on 2015/04/23.
 */
public class SalespersonFactory {

    public static Salesperson createSalesperson(String LastName, String FirstName) {
        Salesperson sales = new Salesperson
                .Builder(LastName)
                .FirstName(FirstName)
                .build();
        return sales;
    }
}

