package com.nixcource.recipes.service;

import com.nixcource.recipes.data.Ingredient;

public interface IngredientService extends AbstractService<Ingredient> {
    Ingredient findByName(String name);
}
