package structural.patterns.decorator;

import java.math.BigDecimal;

public class PizzaBase extends PizzaItem {

    private BigDecimal price = BigDecimal.valueOf(32);

    @Override
    public BigDecimal getPrice() {
        System.out.println("Price for pizza base: " + price.toString());
        return price;
    }
}
