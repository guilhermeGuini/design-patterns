package structural.patterns.adapter;

public class HibernateOracleSqlConnection implements OracleSqlConnectionAdaptee {

    @Override
    public void connect(String url, String password) {
        System.out.println("Connecting hibernate to oracle database");
    }

    @Override
    public String getName() {
        return "Hibernate";
    }
}
