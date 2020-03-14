package topcustomers;

import java.util.*;

/**
 * Created by karolos on 14/03/2020.
 */
public class SlowStore extends Store {

    Map<Customer, Double> customerToRunningTotal = new HashMap<>();


    @Override
    public List<CustomerTotal> topCustomersByTotalSpendingDescending(int numberOfCustomers) {

        List<CustomerTotal> toReturn = new ArrayList<>();
        Map<Double,Set<Customer>> sumToCustomers = getSumToCustomers();

        ArrayList<Double> totals = new ArrayList<>(sumToCustomers.keySet());
        Collections.sort(totals, Comparator.reverseOrder());

        int count = 0;
        for(Double customerWithSum : totals)
        {
            for(Customer c : sumToCustomers.get(customerWithSum))
            {

                toReturn.add(new CustomerTotal(c,customerWithSum));
                count ++;
                if (count==numberOfCustomers) break;
            }

            if (count==numberOfCustomers) break;

        }

        return toReturn;
    }

    private Map<Double, Set<Customer>> getSumToCustomers() {

        Map<Double, Set<Customer>> toReturn = new HashMap<>();

        for(Customer c :  customerToRunningTotal.keySet())
        {
            toReturn.putIfAbsent(customerToRunningTotal.get(c), new HashSet<>());
            toReturn.get(customerToRunningTotal.get(c)).add(c);
        }

        return toReturn;
    }

    @Override
    public void insertTransaction(Customer customer, double amount) {
        double curentTotal = customerToRunningTotal.getOrDefault(customer,0.0);
        double newTotal = amount + curentTotal;
        customerToRunningTotal.put(customer, newTotal);
    }
}
