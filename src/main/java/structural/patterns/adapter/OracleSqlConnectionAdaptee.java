package structural.patterns.adapter;

/**
 * Interface adaptee
 */
public interface OracleSqlConnectionAdaptee {

    void connect(String url, String password);

    String getName();
}
