package com.nixcource.recipes.repository.impl;

import com.nixcource.recipes.data.Dish;
import com.nixcource.recipes.data.Ingredient;
import com.nixcource.recipes.data.UnionDishIngredient;
import com.nixcource.recipes.repository.UnionDishIngredientRepository;

import java.util.ArrayList;
import java.util.List;

public class UnionDishIngredientRepositoryImpl implements UnionDishIngredientRepository {

    private final List<UnionDishIngredient> unionDishIngredientList = new ArrayList<>();

    @Override
    public List<Dish> findAllDishesByIngredientName(String ingredient) {
        List<Dish> dishes = new ArrayList<>();
        for (UnionDishIngredient i : unionDishIngredientList) {
            if (i.getIngredient().getName().equals(ingredient)) {
                dishes.add(i.getDish());
            }
        }
        return dishes;
    }

    @Override
    public List<Ingredient> findAllIngredientsByDishName(String dishName) {
        List<Ingredient> ingredients = new ArrayList<>();
        for (UnionDishIngredient i : unionDishIngredientList) {
            if (i.getDish().getName().equals(dishName)) {
                ingredients.add(i.getIngredient());
            }
        }
        return ingredients;
    }

    @Override
    public List<Dish> findDishesByIngredientId(Long id) {
        List<Dish> dishes = new ArrayList<>();
        for (UnionDishIngredient i : unionDishIngredientList) {
            if (i.getIngredient().getId().equals(id)) {
                dishes.add(i.getDish());
            }
        }
        return dishes;
    }

    @Override
    public List<Ingredient> findIngredientsByDishId(Long id) {
        List<Ingredient> ingredients = new ArrayList<>();
        for (UnionDishIngredient i : unionDishIngredientList) {
            if (i.getDish().getId().equals(id)) {
                ingredients.add(i.getIngredient());
            }
        }
        return ingredients;
    }

    @Override
    public void save(UnionDishIngredient unionDishIngredient) {
        unionDishIngredientList.add(unionDishIngredient);
    }

    @Override
    public UnionDishIngredient findById(Long id) {
        for (UnionDishIngredient i : unionDishIngredientList) {
            if (i.getId().equals(id)) {
                return i;
            }
        }
        return null;
    }

    @Override
    public List<UnionDishIngredient> findAll() {
        return unionDishIngredientList;
    }

    @Override
    public void update(UnionDishIngredient unionDishIngredient) {
        for (UnionDishIngredient i: unionDishIngredientList)
        {
            if (i.getId().equals(i.getId())) {
                i.setDish(unionDishIngredient.getDish());
                i.setIngredient(unionDishIngredient.getIngredient());
            }
        }
    }

    @Override
    public void remove(Long id) {
        for (int i = 0; i < unionDishIngredientList.size(); i++) {
            if (unionDishIngredientList.get(i).getId().equals(id)) {
                unionDishIngredientList.remove(i);
                return;
            }
        }
    }
}
