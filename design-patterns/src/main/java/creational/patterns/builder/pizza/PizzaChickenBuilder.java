package creational.patterns.builder.pizza;

public class PizzaChickenBuilder extends PizzaBuilder {

    @Override
    public PizzaBuilder startMontage() {
        super.startMontage();

        edge(Edge.CATUPIRY);
        with(Ingredient.CHICKEN);

        return this;
    }
}
