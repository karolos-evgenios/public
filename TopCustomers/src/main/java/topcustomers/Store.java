package topcustomers;

/**
 * Created by karolos on 14/03/2020.
 */
public abstract class Store implements TopCustomersService {

    public abstract void insertTransaction(Customer customer, double amount);


}
