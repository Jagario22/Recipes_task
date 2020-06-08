package com.nixcource.recipes.builder;

import com.nixcource.recipes.config.ApplicationEnvironment;
import com.nixcource.recipes.data.*;
import com.nixcource.recipes.service.*;
import com.nixcource.recipes.service.impl.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class DataBuilder implements AbstractBuilder {

    private final DishService dishService = new DishServiceImpl();
    private final IngredientService ingredientService = new IngredientServiceImpl();
    private final UnionDishIngredientService unionDishIngredientService = new UnionDishIngredientServiceImpl();

    @Override
    public void buildDataList() {

        for (Map.Entry<String, String> entry : getKeyValueMapByBundleProperties(ApplicationEnvironment.getPropertyLang()).entrySet()) {

            Dish dish = new Dish();

            //Get author from file;
            String dishNameProperties = String.join(" ", entry.getKey().split("_"));
            dish.setName(dishNameProperties);
            dishService.saveOrUpdate(dish);

            if (entry.getValue().contains(";")) { // if value has two or bigger books
                List<String> ingredientNamePropertiesList = Arrays.asList(entry.getValue().split(";"));
                for (String name : ingredientNamePropertiesList) {
                    Ingredient ingredient = new Ingredient();
                    ingredient.setName(name);

                    UnionDishIngredient unionDishIngredient = new UnionDishIngredient();
                    unionDishIngredient.setDish(dish);
                    unionDishIngredient.setIngredient(ingredient);

                    unionDishIngredientService.saveOrUpdate(unionDishIngredient);
                    ingredientService.saveOrUpdate(ingredient);
                }
            } else {
                Ingredient ingredient = new Ingredient();
                String ingredientName = entry.getValue();
                ingredient.setName(ingredientName);

                UnionDishIngredient unionDishIngredient = new UnionDishIngredient();
                unionDishIngredient.setDish(dish);
                unionDishIngredient.setIngredient(ingredient);

                unionDishIngredientService.saveOrUpdate(unionDishIngredient);
                ingredientService.saveOrUpdate(ingredient);
            }
        }
//        bookRegisterService.findAll().forEach(i -> {
//            System.out.println(i.getAuthor().getFullName() + ": " + i.getBook().getBookName());
//        });
//        for (Dish dish: dishService.findAll())
//        {
//            System.out.print(dish.getName() + ": ");
//            for (Ingredient i: unionDishIngredientService.findAllIngredientsByDishName(dish.getName()))
//                System.out.print(i.getName() +"; ");
//            System.out.println();
//        }

//        for (Ingredient ingredient: ingredientService.findAll())
//        {
//            System.out.println(ingredient.getName());
//        }
//        bookService.findAll().forEach(book -> {
//            System.out.println("book = " + book.getBookName());
//        });

//        for (Dish dish : unionDishIngredientService.findDishesByIngredientId(1L)) {
//            System.out.println(dish.getName());
//        }

//        for (Ingredient i: unionDishIngredientService.findAllIngredientsByDishName("Potato pie"))
//        {
//            System.out.println(i.getName());
//        }
    }

    public DishService getDishService() {
        return dishService;
    }

    public IngredientService getIngredientService() {
        return ingredientService;
    }

    public UnionDishIngredientService getUnionDishIngredientService() {
        return unionDishIngredientService;
    }
}
