package com.nixcource.recipes;

import com.nixcource.recipes.builder.DataBuilder;
import com.nixcource.recipes.config.ApplicationEnvironment;
import com.nixcource.recipes.service.DishService;
import com.nixcource.recipes.service.IngredientService;
import com.nixcource.recipes.service.UnionDishIngredientService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RecipesApplicationTests{

    @BeforeAll
    public static void setEnv() {
        ApplicationEnvironment.setPropertyLang("en");
    }

    @Test
    public void build() {
        DataBuilder dataBuilder = new DataBuilder();
        DishService dishService = dataBuilder.getDishService();
        IngredientService ingredientService = dataBuilder.getIngredientService();
        UnionDishIngredientService unionDishIngredientService = dataBuilder.getUnionDishIngredientService();
        dataBuilder.buildDataList();

        assertEquals(8, dishService.findAll().size());
        assertEquals(ingredientService.findAll().size(), 24);

        assertEquals(dishService.findByName("Potato pie").getName(), "Potato pie");
        assertEquals("potato", ingredientService.findByName("potato").getName());

        assertEquals(2, unionDishIngredientService.findAllDishesByIngredientName("onion").size());
        assertEquals(10, unionDishIngredientService.findAllIngredientsByDishName("Salad").size());

        assertEquals("Roasted salmon",dishService.findById(1L).getName());
        assertEquals(5,unionDishIngredientService.findIngredientsByDishId(1L).size());
        assertEquals("potato",ingredientService.findById(1L).getName());
        assertEquals(2,unionDishIngredientService.findDishesByIngredientId(1L).size());

        dishService.remove(1L);
        assertNull(dishService.findById(1L));
        assertEquals(7, dishService.findAll().size());

        ingredientService.remove(1L);
        assertNull(ingredientService.findById(1L));
        assertEquals(23, ingredientService.findAll().size());

        unionDishIngredientService.remove(1L);
        assertNull(ingredientService.findById(1L));
    }

}