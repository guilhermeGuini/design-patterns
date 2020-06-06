package structural.patterns.adapter;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class AdapterTest {

    @Test
    public void shouldExecuteEclipseLink() {
        OracleSqlConnectionAdapter adapter = new OracleSqlConnectionAdapterImpl(new EclipseLinkOracleSqlConnection());
        adapter.connect("anyUrl", "anyPassword");
        assertEquals("Eclipse Link", adapter.getName());
    }

    @Test
    public void shouldExecuteHibernate() {
        OracleSqlConnectionAdapter adapter = new OracleSqlConnectionAdapterImpl(new HibernateOracleSqlConnection());
        adapter.connect("anyUrl", "anyPassword");
        assertEquals("Hibernate", adapter.getName());
    }
}
