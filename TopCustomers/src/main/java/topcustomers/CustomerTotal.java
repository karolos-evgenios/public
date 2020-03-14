package topcustomers;

/**
 * Created by karolos on 14/03/2020.
 */
public class CustomerTotal implements Comparable<CustomerTotal> {


    private final Customer customer;
    private  double currentTotal;


    public  CustomerTotal(Customer  customer , double total )
    {
        this.customer = customer ;
        this.currentTotal = total;
    }


    @Override
    public int compareTo(CustomerTotal other) {

        if ( currentTotal> other.currentTotal)
            return -1;
        else if ( currentTotal < other.currentTotal )
            return  1;

        return Double.compare(customer.getId(), other.customer.getId());
    }

    public Customer getCustomer() {
        return customer;
    }


    public CustomerTotal add(double transactionAmount) {
        currentTotal += transactionAmount;
        return this;
    };

    public double getTotal() {
        return currentTotal;
    }
}
