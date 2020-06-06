package creational.patterns.prototype;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PlayerTest {

    @Test
    public void shouldCreateCounterTerrorist() {
        PlayerCache.loadCache();

        Player ct = PlayerCache.getPlayer("CT");
        ct.printName();
        assertEquals(Boolean.FALSE, ct.getTerrorist());
        assertTrue("Player should be instance of Counter Terrorist", ct instanceof CounterTerrorist);
    }

    @Test
    public void shouldCreateTerrorist() {
        PlayerCache.loadCache();

        Player tr = PlayerCache.getPlayer("TR");
        tr.printName();
        assertEquals(Boolean.TRUE, tr.getTerrorist());
        assertTrue("Player should be instance of Terrorist", tr instanceof Terrorist);
    }
}
