package jha.gaurav.recipe.dtoModels;

import jakarta.persistence.*;
import jha.gaurav.recipe.model.Ingredient;
import jha.gaurav.recipe.model.Recipe;
import jha.gaurav.recipe.model.UnitOfMeasure;

import java.math.BigDecimal;

public class IngredientWithMeasurementDto {
    private Long id;
    private String description;
    private BigDecimal amount;
    private UnitOfMeasureDto unitOfMeasure;
    private IngredientDto ingredient;
    private RecipeDto recipe;

}
