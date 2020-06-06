package creational.patterns.builder.pizza;

import java.util.List;

public class Pizza {

    private Edge edge;
    private List<Ingredient> ingredients;

    public Edge getEdge() {
        return edge;
    }

    public void setEdge(Edge edge) {
        this.edge = edge;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }
}
