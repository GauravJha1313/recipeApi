package jha.gaurav.recipe.dtoModels;

import jha.gaurav.recipe.enums.Difficulty;
import jha.gaurav.recipe.model.AllergyWarning;
import jha.gaurav.recipe.model.Category;
import jha.gaurav.recipe.model.IngredientWithMeasurement;
import jha.gaurav.recipe.model.Notes;

import java.util.HashSet;
import java.util.Set;

public class RecipeDto {
    private Long id;
    private String name;
    private String description;
    private Integer prepTime;
    private Integer cookTime;
    private Integer servings;
    private String directions;
    private Set<IngredientWithMeasurementDto> ingredients = new HashSet<>();
    private Difficulty difficulty;
    private Notes notes;
    private Set<CategoryDto> categories = new HashSet<>();
    private Set<AllergyWarningDto> allergyWarnings;
}
