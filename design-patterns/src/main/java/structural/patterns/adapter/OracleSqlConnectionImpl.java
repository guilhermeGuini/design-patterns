package structural.patterns.adapter;

/**
 * Client implementation
 */
public class OracleSqlConnectionImpl implements OracleSqlConnection {

    @Override
    public void connect(String url, String password) {
        System.out.println("Connecting to dabase oracle");
    }

    @Override
    public String getName() {
        return "Oracle";
    }
}
