package structural.patterns.adapter;

/**
 * Target
 */
public interface OracleSqlConnection {

    void connect(String url, String password);

    String getName();
}
