package structural.patterns.decorator;

import java.math.BigDecimal;

public class Cheese extends PizzaItemDecorator {

    public Cheese(PizzaItem pizzaItem) {
        super(pizzaItem);
    }

    @Override
    public BigDecimal getPrice() {
        BigDecimal basePrice = super.getPrice();
        System.out.println("Adding $3.00 to base price for additional ingredient cheese");
        return basePrice.add(BigDecimal.valueOf(3));
    }
}
