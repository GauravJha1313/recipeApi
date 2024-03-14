package jha.gaurav.recipe.dtoModels;

import jakarta.persistence.*;
import jha.gaurav.recipe.model.IngredientWithMeasurement;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.Set;

public class UnitOfMeasureDto {
    private Long id;
    private String unit;
}
