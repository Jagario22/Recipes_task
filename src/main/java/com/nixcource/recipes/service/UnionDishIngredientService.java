package com.nixcource.recipes.service;

import com.nixcource.recipes.data.Dish;
import com.nixcource.recipes.data.Ingredient;
import com.nixcource.recipes.data.UnionDishIngredient;

import java.util.List;

public interface UnionDishIngredientService extends AbstractService<UnionDishIngredient> {

    List<Dish> findAllDishesByIngredientName(String ingredient);

    List<Ingredient> findAllIngredientsByDishName(String dishName);

    List<Dish> findDishesByIngredientId(Long id);

    List<Ingredient> findIngredientsByDishId(Long id);
}
