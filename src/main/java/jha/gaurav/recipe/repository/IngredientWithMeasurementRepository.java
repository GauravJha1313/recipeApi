package jha.gaurav.recipe.repository;

import jha.gaurav.recipe.model.IngredientWithMeasurement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientWithMeasurementRepository extends JpaRepository<IngredientWithMeasurement,Long> {}
