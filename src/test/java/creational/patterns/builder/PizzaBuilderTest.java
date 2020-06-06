package creational.patterns.builder;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import creational.patterns.builder.pizza.*;
import org.junit.Test;

public class PizzaBuilderTest {

    @Test
    public void shouldCreatePizzaWithCustomIngredients() {
        PizzaBuilder pizzaBuilder = new PizzaBuilder();
        pizzaBuilder.edge(Edge.CHOCOLATE);
        pizzaBuilder.with(Ingredient.CHEESE);
        pizzaBuilder.with(Ingredient.CATUPIRY);
        Pizza pizza = pizzaBuilder.build();

        assertEquals(Edge.CHOCOLATE, pizza.getEdge());
        assertEquals(2, pizza.getIngredients().size());
        assertTrue("List of ingredients not contain Cheese", pizza.getIngredients().contains(Ingredient.CHEESE));
        assertTrue("List of ingredients not contain Catupiry", pizza.getIngredients().contains(Ingredient.CATUPIRY));
    }

    @Test
    public void shouldCreateCatupiryPizza() {
        Pizza pizza = new PizzaCatupiryBuilder()
                                .startMontage()
                                .build();

        assertEquals(Edge.CATUPIRY, pizza.getEdge());
        assertEquals(2, pizza.getIngredients().size());
        assertTrue("List of ingredients not contain Catupiry", pizza.getIngredients().contains(Ingredient.CATUPIRY));
        assertTrue("List of ingredients not contain Cheese", pizza.getIngredients().contains(Ingredient.CHEESE));
    }

    @Test
    public void shouldCreateChickenPizza() {
        Pizza pizza = new PizzaChickenBuilder()
                                .startMontage()
                                .build();

        assertEquals(Edge.CATUPIRY, pizza.getEdge());
        assertEquals(2, pizza.getIngredients().size());
        assertTrue("List of ingredients not contain Chicken", pizza.getIngredients().contains(Ingredient.CHICKEN));
        assertTrue("List of ingredients not contain Cheese", pizza.getIngredients().contains(Ingredient.CHEESE));
    }
}
