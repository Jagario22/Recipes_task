package com.nixcource.recipes.service.impl;

import com.nixcource.recipes.data.Dish;
import com.nixcource.recipes.data.Ingredient;
import com.nixcource.recipes.data.UnionDishIngredient;
import com.nixcource.recipes.repository.UnionDishIngredientRepository;
import com.nixcource.recipes.repository.impl.UnionDishIngredientRepositoryImpl;
import com.nixcource.recipes.service.UnionDishIngredientService;

import java.util.List;

public class UnionDishIngredientServiceImpl implements UnionDishIngredientService {
    private final UnionDishIngredientRepository unionDishIngredRepository = new UnionDishIngredientRepositoryImpl();

    @Override
    public List<Dish> findAllDishesByIngredientName(String ingredient) {
        return unionDishIngredRepository.findAllDishesByIngredientName(ingredient);
    }

    @Override
    public List<Ingredient> findAllIngredientsByDishName(String dishName) {
        return unionDishIngredRepository.findAllIngredientsByDishName(dishName);
    }

    @Override
    public List<Dish> findDishesByIngredientId(Long id) {
        return unionDishIngredRepository.findDishesByIngredientId(id);
    }

    @Override
    public List<Ingredient> findIngredientsByDishId(Long id) {
        return unionDishIngredRepository.findIngredientsByDishId(id);
    }

    @Override
    public void saveOrUpdate(UnionDishIngredient unionDishIngredient) {
        if (unionDishIngredient.getId() == null) {
            long id = findAll().size();
            unionDishIngredient.setId(++id);
            unionDishIngredRepository.save(unionDishIngredient);
        } else {
            unionDishIngredRepository.update(unionDishIngredient);
        }
    }

    @Override
    public UnionDishIngredient findById(Long id) {
        return unionDishIngredRepository.findById(id);
    }

    @Override
    public List<UnionDishIngredient> findAll() {
        return unionDishIngredRepository.findAll();
    }

    @Override
    public void remove(Long id) {
        unionDishIngredRepository.remove(id);
    }
}
