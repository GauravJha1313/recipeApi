package jha.gaurav.recipe.dtoModels;

import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jha.gaurav.recipe.model.IngredientWithMeasurement;

import java.util.Set;

public class IngredientDto {
    private Long id;
    private String name;
    private Set<String> otherNames;

}
