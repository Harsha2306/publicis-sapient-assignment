package com.harsha.backend.repository;

import com.harsha.backend.entity.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Integer> {
  @Query(
      "SELECT r FROM Recipe r "
          + "WHERE (:name IS NULL OR LOWER(r.name) LIKE LOWER(CONCAT('%', :name, '%'))) "
          + "OR (:cuisine IS NULL OR LOWER(r.cuisine) LIKE LOWER(CONCAT('%', :cuisine, '%')))")
  List<Recipe> findByNameAndCuisine(@Param("name") String name, @Param("cuisine") String cuisine);
}
