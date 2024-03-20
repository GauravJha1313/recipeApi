package jha.gaurav.recipe.model;

import jakarta.persistence.*;
import jha.gaurav.recipe.enums.Difficulty;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String name;
    private String description;
    private Integer prepTime;
    private Integer cookTime;
    private Integer servings;

    @Column(columnDefinition = "TEXT")
    private String directions;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recipe")
    private Set<IngredientWithMeasurement> ingredients = new HashSet<>();

    @Enumerated(value = EnumType.STRING)
    private Difficulty difficulty;

    @OneToOne(cascade = CascadeType.ALL)
    private Notes notes;

    @ManyToMany
    @JoinTable(name = "recipe_category",
            joinColumns = @JoinColumn(name = "recipe_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<Category> categories = new HashSet<>();
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recipe")
    private Set<AllergyWarning> allergyWarnings;

    public void setNotes(Notes notes) {
        if (notes != null) {
            this.notes = notes;
            notes.setRecipe(this);
        }
    }

    public void addIngredient(IngredientWithMeasurement ingredientWithMeasurement){
        ingredientWithMeasurement.setRecipe(this);
        this.ingredients.add(ingredientWithMeasurement);
    }

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

}