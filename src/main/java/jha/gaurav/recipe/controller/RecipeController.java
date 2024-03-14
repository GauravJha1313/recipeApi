package jha.gaurav.recipe.controller;

import jha.gaurav.recipe.model.Recipe;
import jha.gaurav.recipe.service.RecipeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/recipe")
@RequiredArgsConstructor
public class RecipeController {
    private final RecipeService recipeService;
    @PostMapping
    public ResponseEntity<?> save(@RequestBody Recipe recipe) {
        recipe = recipeService.addRecipe(recipe);
        return ResponseEntity.ok(recipe);
    }

    @GetMapping
    public ResponseEntity<List<Recipe>> findAllBooks() {
        return ResponseEntity.ok(recipeService.allRecipe());
    }
}
