package jha.gaurav.recipe.repository;

import jha.gaurav.recipe.model.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IngredientRepository extends JpaRepository<Ingredient,Long> {
    Optional<Ingredient> findByName(String name);
}
