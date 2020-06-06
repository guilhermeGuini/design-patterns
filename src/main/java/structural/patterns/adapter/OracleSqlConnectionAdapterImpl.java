package structural.patterns.adapter;

public class OracleSqlConnectionAdapterImpl implements OracleSqlConnectionAdapter {

    private OracleSqlConnectionAdaptee adaptee;

    public OracleSqlConnectionAdapterImpl(OracleSqlConnectionAdaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void connect(String url, String password) {
        adaptee.connect(url, password);
    }

    @Override
    public String getName() {
        return adaptee.getName();
    }
}
