package com.harsha.backend.service;

import com.harsha.backend.dto.RecipeFromAPIItemDto;
import com.harsha.backend.entity.Recipe;
import com.harsha.backend.exception.RecipeNotFoundException;
import com.harsha.backend.repository.RecipeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class RecipeService {
  private final RecipeRepository recipeRepository;

  public void saveAll(List<RecipeFromAPIItemDto> recipes) {
    recipeRepository.saveAll(recipes.stream().map(this::mapToRecipe).toList());
    log.info("saved recipes to h2");
  }

  private Recipe mapToRecipe(RecipeFromAPIItemDto recipeFromAPIItemDto) {
    return Recipe.builder()
        .id(recipeFromAPIItemDto.getId())
        .name(recipeFromAPIItemDto.getName())
        .ingredients(recipeFromAPIItemDto.getIngredients())
        .instructions(recipeFromAPIItemDto.getInstructions())
        .prepTimeMinutes(recipeFromAPIItemDto.getPrepTimeMinutes())
        .cookTimeMinutes(recipeFromAPIItemDto.getCookTimeMinutes())
        .servings(recipeFromAPIItemDto.getServings())
        .difficulty(recipeFromAPIItemDto.getDifficulty())
        .cuisine(recipeFromAPIItemDto.getCuisine())
        .caloriesPerServing(recipeFromAPIItemDto.getCaloriesPerServing())
        .tags(recipeFromAPIItemDto.getTags())
        .userId(recipeFromAPIItemDto.getUserId())
        .image(recipeFromAPIItemDto.getImage())
        .rating(recipeFromAPIItemDto.getRating())
        .reviewCount(recipeFromAPIItemDto.getReviewCount())
        .mealType(recipeFromAPIItemDto.getMealType())
        .build();
  }

  public Recipe findRecipeById(Integer id) {
    Optional<Recipe> optionalRecipe = recipeRepository.findById(id);
    if (optionalRecipe.isEmpty())
      throw new RecipeNotFoundException("recipe with id: " + id + " not found");
    return optionalRecipe.get();
  }

  public List<Recipe> getRecipesByNameAndCuisine(String name, String cuisine) {
    return recipeRepository.findByNameAndCuisine(name, cuisine);
  }
}
