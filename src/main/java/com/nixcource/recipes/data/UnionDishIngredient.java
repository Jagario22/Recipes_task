package com.nixcource.recipes.data;

public class UnionDishIngredient extends AbstractData<UnionDishIngredient> {
    private Dish dish;
    private Ingredient ingredient;

    public Dish getDish() {
        return dish;
    }

    public void setDish(Dish dish) {
        this.dish = dish;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }
}
