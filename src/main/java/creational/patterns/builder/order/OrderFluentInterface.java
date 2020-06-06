package creational.patterns.builder.order;

import java.util.ArrayList;
import java.util.List;

public final class OrderFluentInterface {

    public interface IBreadType {
        ICheeseType withBread(BreadType breadType);
    }

    public interface ICheeseType {
        IClientName withCheese(CheeseType cheeseType);
    }

    public interface IClientName {
        IClientAddress to(String clientName);
    }

    public interface IClientAddress {
        IAddtionalIngredient at(String address);
    }

    public interface IAddtionalIngredient {
        Final with(Ingredient ingredient);
    }

    public interface Final {
        Final with(Ingredient ingredient);
        Order build();
    }

    public static class OrderFluentInterfaceBuilder implements IBreadType, ICheeseType, IClientName, IClientAddress, IAddtionalIngredient, Final {

        private List<Ingredient> ingredientList = new ArrayList<>();
        private CheeseType cheeseType;
        private BreadType breadType;
        private String clientName;
        private String address;

        private OrderFluentInterfaceBuilder() {
            // avoid instance creation
        }

        public static IBreadType getInstance() {
            return new OrderFluentInterfaceBuilder();
        }

        @Override
        public ICheeseType withBread(BreadType breadType) {
            this.breadType = breadType;
            return this;
        }

        @Override
        public IClientName withCheese(CheeseType cheeseType) {
            this.cheeseType = cheeseType;
            return this;
        }

        @Override
        public IClientAddress to(String clientName) {
            this.clientName = clientName;
            return this;
        }

        @Override
        public IAddtionalIngredient at(String address) {
            this.address = address;
            return this;
        }

        @Override
        public Final with(Ingredient ingredient) {
            this.ingredientList.add(ingredient);
            return this;
        }

        @Override
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
}