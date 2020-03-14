import topcustomers.Customer;
import topcustomers.Transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by karolos on 14/03/2020.
 */
public class DataGenerator {


    static public  List<Transaction> getTransactions(int customers, int customerTransations, long seed)
    {

        Customer[] customerArray = new Customer[customers];
        for (int i = 0; i < customerArray.length; i++) {
            customerArray[i] = new Customer(i,"");
        }


        List<Transaction> transactions = new ArrayList<>();
        Random random = new Random(seed);


        for (int i = 0; i < customerTransations; i++) {
            transactions.add(new Transaction(customerArray[Math.abs(random.nextInt(customers))], (double ) Math.abs(random.nextInt(10))));
        }
        return transactions;

    }
}
