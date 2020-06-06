package structural.patterns.composite;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.util.List;

public class CompositeTest {

    @Test
    public void shouldCreateWindowWithLeafs() {
        Component window = new Window("Main");
        window.add(new Field("name"));
        window.add(new Field("phone"));
        window.add(new Button("save"));
        window.add(new Button("cancel"));

        List<String> names = window.getComponentNames();
        assertTrue(names.contains("Main"));
        assertTrue(names.contains("name"));
        assertTrue(names.contains("phone"));
        assertTrue(names.contains("save"));
        assertTrue(names.contains("cancel"));
    }

    @Test
    public void shouldCreateWindowWithChildrenAndLeafs() {
        Component window = new Window("Main");
        window.add(new Field("id"));
        window.add(new Button("save"));
        window.add(new Button("cancel"));

        Component group = new Group("Customer");
        group.add(new Field("name"));
        group.add(new Field("address"));

        window.add(group);

        List<String> names = window.getComponentNames();
        assertTrue(names.contains("Main"));
        assertTrue(names.contains("id"));
        assertTrue(names.contains("save"));
        assertTrue(names.contains("cancel"));
        assertTrue(names.contains("Customer"));
        assertTrue(names.contains("name"));
        assertTrue(names.contains("address"));
    }
}
