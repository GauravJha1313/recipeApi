package jha.gaurav.recipe.repository;

import jha.gaurav.recipe.model.UnitOfMeasure;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UnitOfMeasureRepository extends JpaRepository<UnitOfMeasure,Long> {
    Optional<UnitOfMeasure> findByUnit(String unitOfMeasure);
}
