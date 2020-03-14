package topcustomers;

import java.util.List;

/**
 * Created by karolos on 14/03/2020.
 */
public interface TopCustomersService {


    List<CustomerTotal> topCustomersByTotalSpendingDescending(int numberOfCustomers);

}
