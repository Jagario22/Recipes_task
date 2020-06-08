package com.nixcource.recipes.service;

import com.nixcource.recipes.data.Dish;

public interface DishService extends  AbstractService<Dish> {
    Dish findByName(String name);
}
