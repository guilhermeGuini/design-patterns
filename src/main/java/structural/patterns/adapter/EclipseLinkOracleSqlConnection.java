package structural.patterns.adapter;

public class EclipseLinkOracleSqlConnection implements OracleSqlConnectionAdaptee {

    @Override
    public void connect(String url, String password) {
        System.out.println("Connecting eclipseLink to Oracle Database");
    }

    @Override
    public String getName() {
        return "Eclipse Link";
    }
}
