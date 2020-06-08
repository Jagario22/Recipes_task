package com.nixcource.recipes.repository;

import com.nixcource.recipes.data.Dish;

public interface DishRepository extends AbstractRepository<Dish> {

    Dish findByName(String name);
}
