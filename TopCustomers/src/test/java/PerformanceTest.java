import topcustomers.*;

import java.util.List;

/**
 * Created by karolos on 14/03/2020.
 */
public class PerformanceTest {

    /*

            Total customers : 1_000_000
            Total transactions : 10_000_000
            Top customers : 5

            topcustomers.SlowStore@511d50c0 ===================

            Ingestion time in milliseconds 4404
            Query time in milliseconds 2696
            Top 5
                295524 	 146.0
                695414 	 145.0
                942625 	 144.0
                104455 	 142.0
                49942 	 133.0


            topcustomers.FastStore@25fda37 ===================

            Ingestion time in milliseconds 38509
            Query time in milli seconds 7
            Top 5
                295524 	 146.0
                695414 	 145.0
                942625 	 144.0
                104455 	 142.0
                49942 	 133.0

     */


    public static void main(String[] args) {

        int topCustomers = 5;
        int customers = 1_000_000;
        int customerTransactions = 10_000_000;
        long seed = 111;
        List<Transaction> transactions = DataGenerator.getTransactions(customers, customerTransactions, seed);

        Store slowStore = new SlowStore();
        Store fastStore = new FastStore();

        System.out.println("Total customers : " + customers);
        System.out.println("Total transactions : " + customerTransactions);
        System.out.println("Top customers : " + topCustomers);


        profile(slowStore,transactions,topCustomers);
        profile(fastStore,transactions,topCustomers);
    }

    private static void profile(Store store, List<Transaction> transactions,  int topCustomers) {

        System.out.println(store  + " ===================\n ");

        long beforeIngestion = System.currentTimeMillis();
        for(Transaction t : transactions)
        {
            store.insertTransaction(t.getCustomerId(),t.getTransactionAmount());
        }
        long afterIngestion = System.currentTimeMillis();


        List<CustomerTotal> result = store.topCustomersByTotalSpendingDescending(topCustomers);
        long afterQuery= System.currentTimeMillis();


        System.out.println("Ingestion time in milliseconds " + ((afterIngestion-beforeIngestion)));
        System.out.println("Query time in milliseconds " + ((afterQuery - afterIngestion)));
        System.out.println("Top " + topCustomers + " ") ;
        result.forEach( x -> System.out.println("\t" + x.getCustomer().getId() + " \t " + x.getTotal()));
        System.out.print("\n\n");

    }


}
