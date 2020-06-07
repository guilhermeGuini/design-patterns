package creational.patterns.singleton;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class EngineTest {

    @Test
    public void instancesShouldBeEquals() {

        Engine engineInstance1 = Engine.getInstance();
        Engine engineInstance2 = Engine.getInstance();

        assertTrue("Instances aren't equals", engineInstance1 == engineInstance2);
    }

}
