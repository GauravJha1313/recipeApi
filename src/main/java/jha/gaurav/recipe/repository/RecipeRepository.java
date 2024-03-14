package jha.gaurav.recipe.repository;

import jha.gaurav.recipe.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeRepository extends JpaRepository<Recipe,Long> {}
