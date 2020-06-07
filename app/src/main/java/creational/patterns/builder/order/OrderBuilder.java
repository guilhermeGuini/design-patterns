package creational.patterns.builder.order;

import java.util.ArrayList;
import java.util.List;

public final class OrderBuilder {

    private List<Ingredient> ingredientList = new ArrayList<>();
    private CheeseType cheeseType;
    private BreadType breadType;
    private String clientName;
    private String address;

    private OrderBuilder() {
        // avoid instance creation
    }

    public static OrderBuilder init() {
        return new OrderBuilder();
    }

    public OrderBuilder with(Ingredient ingredient) {
        this.ingredientList.add(ingredient);
        return this;
    }

    public OrderBuilder withBread(BreadType bread) {
        this.breadType = bread;
        return this;
    }

    public OrderBuilder withChesse(CheeseType cheeseType) {
        this.cheeseType = cheeseType;
        return this;
    }

    public OrderBuilder to(String clientName) {
        this.clientName = clientName;
        return this;
    }

    public OrderBuilder at(String address) {
        this.address = address;
        return this;
    }

    public Order build() {

        if (ingredientList.isEmpty() || breadType == null || cheeseType == null) {
            throw new IllegalArgumentException();
        }

        Order order = new Order();
        order.setAddress(address);
        order.setClientName(clientName);

        Hamburguer hamburguer = new Hamburguer();
        hamburguer.setBreadType(breadType);
        hamburguer.setCheeseType(cheeseType);
        hamburguer.setIngredientList(ingredientList);

        order.setHamburguer(hamburguer);

        return order;
    }

}
