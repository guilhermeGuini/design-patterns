package creational.patterns.builder.pizza;

public class PizzaCatupiryBuilder extends PizzaBuilder {

    @Override
    public PizzaBuilder startMontage() {
        super.startMontage();

        edge(Edge.CATUPIRY);
        with(Ingredient.CATUPIRY);

        return this;
    }
}
