package strsuctural.patterns.decorator;

import static org.junit.Assert.*;

import org.junit.Test;
import structural.patterns.decorator.*;

import java.math.BigDecimal;

public class DecoratorTest {

    @Test
    public void shouldCreatePizzaBase() {

        PizzaItem item = new PizzaBase();
        assertTrue(BigDecimal.valueOf(32).compareTo(item.getPrice()) == 0);
    }

    @Test
    public void shouldCreatePizzaWithAdditionalIngredients() {

        PizzaItemDecorator decorator = new Cheese(new Tomato(new PizzaBase()));
        assertTrue(BigDecimal.valueOf(37).compareTo(decorator.getPrice()) == 0);
    }
}
