package structural.patterns.decorator;

import java.math.BigDecimal;

public class Tomato extends PizzaItemDecorator {

    public Tomato(PizzaItem pizzaItem) {
        super(pizzaItem);
    }

    @Override
    public BigDecimal getPrice() {
        BigDecimal basePrice = super.getPrice();
        System.out.println("Adding $2.00 to base price for additional ingredient tomato");
        return basePrice.add(BigDecimal.valueOf(2));
    }
}
