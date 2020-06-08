package com.nixcource.recipes.service.impl;

import com.nixcource.recipes.data.Ingredient;
import com.nixcource.recipes.repository.IngredientRepository;
import com.nixcource.recipes.repository.impl.IngredientRepositoryImpl;
import com.nixcource.recipes.service.IngredientService;

import java.util.List;

public class IngredientServiceImpl implements IngredientService {
    private final IngredientRepository ingredientRepository = new IngredientRepositoryImpl();

    @Override
    public Ingredient findByName(String name) {
        return ingredientRepository.findByName(name);
    }

    @Override
    public void saveOrUpdate(Ingredient ingredient) {
        if (ingredient.getId() == null) {
            for(Ingredient i: ingredientRepository.findAll()) {
                if (i.getName().equals(ingredient.getName()))
                {
                    ingredient.setId(i.getId());
                    return;
                }
            }
            long id = findAll().size();
            ingredient.setId(++id);
            ingredientRepository.save(ingredient);
        } else {
            ingredientRepository.update(ingredient);
        }
    }

    @Override
    public Ingredient findById(Long id) {
        return ingredientRepository.findById(id);
    }

    @Override
    public List<Ingredient> findAll() {
        return ingredientRepository.findAll();
    }

    @Override
    public void remove(Long id) {
        ingredientRepository.remove(id);
    }
}
