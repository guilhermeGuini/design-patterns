package creational.patterns.builder;

import static org.junit.Assert.*;

import creational.patterns.builder.order.*;
import org.junit.Test;

public class OrderBuilderTest {

    @Test(expected = IllegalArgumentException.class)
    public void shouldNotCreateOrderObject() {

        OrderBuilder.init().build();

    }

    @Test
    public void shouldCreateOrderObject() {
        Order order = OrderBuilder.init()
                .withBread(BreadType.AUSTRALIAN)
                .withChesse(CheeseType.CHEDDAR)
                .with(Ingredient.BACON)
                .to("Guilherme Guini")
                .at("Green Avenue - 879")
                .build();

        assertEquals("Guilherme Guini", order.getClientName());
        assertEquals("Green Avenue - 879", order.getAddress());

        Hamburguer hamburguer = order.getHamburguer();

        assertEquals(BreadType.AUSTRALIAN, hamburguer.getBreadType());
        assertEquals(CheeseType.CHEDDAR, hamburguer.getCheeseType());
        assertEquals(1, hamburguer.getIngredientList().size());
        assertEquals(Ingredient.BACON, hamburguer.getIngredientList().get(0));
    }

}
