package jha.gaurav.recipe.service;

import jha.gaurav.recipe.model.*;
import jha.gaurav.recipe.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class RecipeService {

    private final RecipeRepository recipeRepository;
    private final IngredientRepository ingredientRepository;
    private final IngredientWithMeasurementRepository ingredientWithMeasurementRepository;
    private final UnitOfMeasureRepository unitOfMeasureRepository;
    private final CategoryRepository categoryRepository;
    public Recipe addRecipe(Recipe recipe){
        for (IngredientWithMeasurement ingredientWithMeasurement : recipe.getIngredients()) {
            Ingredient ingredient = ingredientRepository.findByName(ingredientWithMeasurement.getIngredient().getName())
                    .orElseGet(() -> {
                        Ingredient newIngredient = new Ingredient();
                        newIngredient.setName(ingredientWithMeasurement.getIngredient().getName());
                        return ingredientRepository.save(newIngredient);
                    });
            ingredientWithMeasurement.setIngredient(ingredient);
            UnitOfMeasure unitOfMeasure = unitOfMeasureRepository.findByUnit(ingredientWithMeasurement.getUnitOfMeasure().getUnit())
                    .orElseGet(() -> {
                        UnitOfMeasure newUnitOfMeasure = new UnitOfMeasure();
                        newUnitOfMeasure.setUnit(ingredientWithMeasurement.getUnitOfMeasure().getUnit());
                        return unitOfMeasureRepository.save(newUnitOfMeasure);
                    });
            ingredientWithMeasurement.setUnitOfMeasure(unitOfMeasure);
            recipe.addIngredient(ingredientWithMeasurement);
        }
        Set<Category> categories = new HashSet<>();
        for (Category category : recipe.getCategories()) {
            Category c = categoryRepository.findByName(category.getName())
                    .orElseGet(
                            () -> {
                                Category newCategory = new Category();
                                newCategory.setName(category.getName());
                                return categoryRepository.save(newCategory);
                            });
            categories.add(c);
        }
        recipe.setCategories(categories);
        return recipeRepository.saveAndFlush(recipe);
    }

    public List<Recipe> allRecipe() {
        return recipeRepository.findAll();
    }
}
