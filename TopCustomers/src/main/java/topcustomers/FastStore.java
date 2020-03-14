package topcustomers;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by karolos on 14/03/2020.
 */
public class FastStore extends Store{


    Map<Long, CustomerTotal> customerToRunningTotal = new HashMap<>();
    Set<CustomerTotal> treeSet = new TreeSet<>();


    @Override
    public void insertTransaction(Customer customer , double transactionAmount)
    {
        CustomerTotal curentTotal = customerToRunningTotal.getOrDefault(customer.getId(),new CustomerTotal(customer,0));
        treeSet.remove(curentTotal);
        curentTotal.add(transactionAmount);
        customerToRunningTotal.put(customer.getId(), curentTotal);
        treeSet.add(curentTotal);
    }

    @Override
    public List<CustomerTotal> topCustomersByTotalSpendingDescending(int numberOfCustomers) {
        return treeSet.stream().limit(numberOfCustomers).collect(Collectors.toList());
    }

}
