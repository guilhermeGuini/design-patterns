package creational.patterns.builder.order;

import java.util.List;

public class Hamburguer {

    private BreadType breadType;

    private CheeseType cheeseType;

    private List<Ingredient> ingredientList;

    public void setBreadType(BreadType breadType) {
        this.breadType = breadType;
    }

    public BreadType getBreadType() {
        return breadType;
    }

    public void setCheeseType(CheeseType cheeseType) {
        this.cheeseType = cheeseType;
    }

    public CheeseType getCheeseType() {
        return cheeseType;
    }

    public List<Ingredient> getIngredientList() {
        return ingredientList;
    }

    public void setIngredientList(List<Ingredient> ingredientList) {
        this.ingredientList = ingredientList;
    }
}
