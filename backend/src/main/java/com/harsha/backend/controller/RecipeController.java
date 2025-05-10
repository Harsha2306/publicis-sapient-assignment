package com.harsha.backend.controller;

import com.harsha.backend.entity.Recipe;
import com.harsha.backend.service.RecipeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("recipes")
public class RecipeController {

  private final RecipeService recipeService;

  @GetMapping("/{id}")
  public ResponseEntity<Recipe> getRecipeById(@PathVariable Integer id) {
    return ResponseEntity.ok(recipeService.findRecipeById(id));
  }

  @GetMapping
  public ResponseEntity<List<Recipe>> getRecipesByNameAndCuisine(
      @RequestParam String name, @RequestParam String cuisine) {
    return ResponseEntity.ok(recipeService.getRecipesByNameAndCuisine(name, cuisine));
  }
}
