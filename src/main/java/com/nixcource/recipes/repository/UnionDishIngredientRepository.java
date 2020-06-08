package com.nixcource.recipes.repository;

import com.nixcource.recipes.data.*;
import com.nixcource.recipes.data.UnionDishIngredient;

import java.util.List;

public interface UnionDishIngredientRepository extends AbstractRepository<UnionDishIngredient> {

    List<Dish> findAllDishesByIngredientName(String ingredient);
    List<Ingredient> findAllIngredientsByDishName(String dishName);
    List<Dish> findDishesByIngredientId(Long id);
    List<Ingredient> findIngredientsByDishId(Long id);
}
