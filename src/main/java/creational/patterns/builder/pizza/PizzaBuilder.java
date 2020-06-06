package creational.patterns.builder.pizza;

import java.util.ArrayList;
import java.util.List;

public class PizzaBuilder {

    private Edge edge;
    private List<Ingredient> ingredients;

    public PizzaBuilder () {
        this.ingredients = new ArrayList<>();
    }

    public PizzaBuilder startMontage() {
        System.out.println("Starting montage");
        ingredients.add(Ingredient.CHEESE);
        return this;
    }

    public PizzaBuilder edge(Edge edge) {
        this.edge = edge;
        return this;
    }

    public PizzaBuilder with(Ingredient ingredient) {
        ingredients.add(ingredient);
        return this;
    }

    public Pizza build() {
        if (edge == null || ingredients == null || ingredients.size() == 0) {
            throw new IllegalArgumentException("Edge and ingredients are required");
        }

        Pizza pizza = new Pizza();
        pizza.setEdge(edge);
        pizza.setIngredients(ingredients);

        return pizza;
    }

}