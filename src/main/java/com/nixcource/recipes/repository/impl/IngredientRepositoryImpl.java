package com.nixcource.recipes.repository.impl;

import com.nixcource.recipes.data.Ingredient;
import com.nixcource.recipes.repository.IngredientRepository;

import java.util.ArrayList;
import java.util.List;

public class IngredientRepositoryImpl implements IngredientRepository {
    private final List<Ingredient> ingredientsList = new ArrayList<>();

    @Override
    public Ingredient findByName(String name) {
        for (Ingredient ingredient: ingredientsList) {
            if (ingredient.getName().equals(name))
                return ingredient;
        }

        return null;
    }

    @Override
    public void save(Ingredient ingredient) {
        ingredientsList.add(ingredient);
    }

    @Override
    public Ingredient findById(Long id) {
        for (Ingredient ingredient: ingredientsList) {
            if (ingredient.getId().equals(id))
                return ingredient;
        }

        return null;
    }

    @Override
    public List<Ingredient> findAll() {
        return ingredientsList;
    }

    @Override
    public void update(Ingredient ingredient) {
        for (Ingredient currentIngredient: ingredientsList)
        {
            if (ingredient.getId().equals(currentIngredient.getId())) {
                currentIngredient.setName(ingredient.getName());
            }
        }
    }

    @Override
    public void remove(Long id) {

        for (int i = 0; i < ingredientsList.size(); i++) {
            if (ingredientsList.get(i).getId().equals(id)) {
                ingredientsList.remove(i);
                return;
            }
        }
    }
}
