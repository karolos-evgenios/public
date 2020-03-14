package topcustomers;

/**
 * Created by karolos on 14/03/2020.
 */
public class Transaction
{
    private final double amount;
    private final Customer customer;


    public Transaction(Customer customer, double amount) {
        this.customer = customer;
        this.amount = amount;
    }

    public Customer getCustomerId() {
        return customer;
    }

    public double getTransactionAmount() {
        return amount;
    }
}
