package com.nixcource.recipes.repository;

import com.nixcource.recipes.data.Ingredient;

public interface IngredientRepository extends AbstractRepository<Ingredient> {
    Ingredient findByName(String name);
}
