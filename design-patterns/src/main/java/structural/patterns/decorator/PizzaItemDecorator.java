package structural.patterns.decorator;

import java.math.BigDecimal;

public abstract class PizzaItemDecorator extends PizzaItem {

    private PizzaItem pizzaItem;

    public PizzaItemDecorator(PizzaItem pizzaItem) {
        this.pizzaItem = pizzaItem;
    }

    @Override
    public BigDecimal getPrice() {
        return pizzaItem.getPrice();
    }
}
