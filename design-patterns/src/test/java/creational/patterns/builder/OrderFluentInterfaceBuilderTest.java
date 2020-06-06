package creational.patterns.builder;

import creational.patterns.builder.order.BreadType;
import creational.patterns.builder.order.CheeseType;
import creational.patterns.builder.order.Ingredient;
import creational.patterns.builder.order.OrderFluentInterface;
import org.junit.Test;

public class OrderFluentInterfaceBuilderTest {

    @Test
    public void shouldCreateOrder() {
        OrderFluentInterface.OrderFluentInterfaceBuilder.getInstance()
                                                        .withBread(BreadType.AUSTRALIAN)
                                                        .withCheese(CheeseType.CHEDDAR)
                                                        .to("GUINI")
                                                        .at("Green Avenue")
                                                        .with(Ingredient.BACON)
                                                        .build();
    }
}
