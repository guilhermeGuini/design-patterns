package creational.patterns.abstract_factory;

import static org.junit.Assert.*;

import org.junit.Test;

public class FormatFieldsTest {

    @Test
    public void shouldReturnValueWithLeadingZeros() {
        assertEquals("000021", FormatFields.format("21", 6, TypeField.NUMBER, true));
    }

    @Test
    public void shouldReturnValueWithZerosToTheRight() {
        assertEquals("210000", FormatFields.format("21", 6, TypeField.NUMBER, false));
    }

    @Test
    public void shouldReturnValueWithLeadingBlanks() {
        assertEquals("   TEST", FormatFields.format("TEST", 7, TypeField.TEXT, true));
    }

    @Test
    public void shouldReturnValueWithBlanksOnTheRight() {
        assertEquals("TEST   ", FormatFields.format("TEST", 7, TypeField.TEXT, false));
    }

}
