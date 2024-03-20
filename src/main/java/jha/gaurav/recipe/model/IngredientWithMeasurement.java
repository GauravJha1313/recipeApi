package jha.gaurav.recipe.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class IngredientWithMeasurement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private BigDecimal amount;

    @ManyToOne(fetch = FetchType.LAZY)
    private UnitOfMeasure unitOfMeasure;

    @ManyToOne(fetch = FetchType.LAZY)
    private Ingredient ingredient;

    @ManyToOne(fetch = FetchType.LAZY)
    private Recipe recipe;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @Override
    public String toString() {
        return "IngredientWithMeasurement{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", amount=" + amount +
                ", unitOfMeasure=" + unitOfMeasure +
                ", ingredient=" + ingredient +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}