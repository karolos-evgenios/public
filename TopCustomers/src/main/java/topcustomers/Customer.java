package topcustomers;

/**
 * Created by karolos on 14/03/2020.
 */
public class Customer {

    private final long m_id;
    private final String m_name;

    public Customer(long id , String name)
    {
        this.m_id = id;
        this.m_name = name;
    }

    public long getId() {
        return m_id;
    }

}
