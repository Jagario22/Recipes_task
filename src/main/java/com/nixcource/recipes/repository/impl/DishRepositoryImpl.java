package com.nixcource.recipes.repository.impl;

import com.nixcource.recipes.data.Dish;
import com.nixcource.recipes.repository.DishRepository;

import java.util.ArrayList;
import java.util.List;

public class DishRepositoryImpl implements DishRepository {

    private final List<Dish> dishesList = new ArrayList<>();

    @Override
    public Dish findByName(String name) {
        for (Dish dish: dishesList) {
            if (dish.getName().equals(name))
                return dish;
        }

        return null;
    }

    @Override
    public void save(Dish dish) {
        dishesList.add(dish);
    }

    @Override
    public Dish findById(Long id) {
        for (Dish dish: dishesList) {
            if (dish.getId().equals(id))
                return dish;
        }

        return null;
    }

    @Override
    public List<Dish> findAll() {
        return dishesList;
    }

    @Override
    public void update(Dish dish) {
        for (Dish currentDish: dishesList)
        {
            if (dish.getId().equals(currentDish.getId())) {
                currentDish.setName(dish.getName());
            }
        }
    }

    @Override
    public void remove(Long id) {

        for (int i = 0; i < dishesList.size(); i++) {
            if (dishesList.get(i).getId().equals(id)) {
                dishesList.remove(i);
                return;
            }
        }
    }
}
