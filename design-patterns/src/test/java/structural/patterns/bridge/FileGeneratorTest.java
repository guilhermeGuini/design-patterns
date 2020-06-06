package structural.patterns.bridge;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import structural.patterns.bridge.FileGeneratorAbstraction;
import structural.patterns.bridge.FileGeneratorCustomImpl;
import structural.patterns.bridge.FileGeneratorImpl;

public class FileGeneratorTest {

    @Test
    public void shouldReturnHeaderOriginal() {
        FileGeneratorAbstraction abstraction = new FileGeneratorAbstraction(new FileGeneratorImpl());
        String header = abstraction.generateHeader();
        assertEquals("File Generator, HEADER", header);
    }

    @Test
    public void shouldReturnHeaderCustom() {
        FileGeneratorAbstraction abstraction = new FileGeneratorAbstraction(new FileGeneratorCustomImpl());
        String header = abstraction.generateHeader();
        assertEquals("File Generator, HEADER CUSTOM", header);
    }

    @Test
    public void shouldChangeFileGeneratorImplInExecutionTime() {
        FileGeneratorAbstraction abstraction = new FileGeneratorAbstraction(new FileGeneratorImpl());
        String header = abstraction.generateHeader();
        assertEquals("File Generator, HEADER", header);

        abstraction.setSpec(new FileGeneratorCustomImpl());
        header = abstraction.generateHeader();
        assertEquals("File Generator, HEADER CUSTOM", header);
    }
}