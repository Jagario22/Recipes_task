package com.nixcource.recipes.service.impl;

import com.nixcource.recipes.data.Dish;
import com.nixcource.recipes.repository.DishRepository;
import com.nixcource.recipes.repository.impl.DishRepositoryImpl;
import com.nixcource.recipes.service.DishService;

import java.util.List;

public class DishServiceImpl implements DishService {

    private final DishRepository dishRepository = new DishRepositoryImpl();

    @Override
    public Dish findByName(String name) {
        return dishRepository.findByName(name);
    }

    @Override
    public void saveOrUpdate(Dish dish) {
        if (dish.getId() == null) {
            long id = findAll().size();
            dish.setId(++id);
            dishRepository.save(dish);
        } else {
            dishRepository.update(dish);
        }
    }

    @Override
    public Dish findById(Long id) {
        return dishRepository.findById(id);
    }

    @Override
    public List<Dish> findAll() {
        return dishRepository.findAll();
    }

    @Override
    public void remove(Long id) {
        dishRepository.remove(id);
    }
}
