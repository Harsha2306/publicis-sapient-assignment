package com.harsha.backend.bootstrap;

import com.harsha.backend.dto.RecipeFromAPIItemDto;
import com.harsha.backend.dto.RecipesFromAPIDto;
import com.harsha.backend.service.RecipeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
@Slf4j
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {
  private final RecipeService recipeService;

  @Override
  public void run(String... args) {
    loadRecipes();
  }

  private void loadRecipes() {
    RestTemplate restTemplate = new RestTemplate();
    String url = "https://dummyjson.com/recipes";
    ResponseEntity<RecipesFromAPIDto> responseEntity =
        restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<>() {});
    if (responseEntity.getBody() != null) {
      List<RecipeFromAPIItemDto> recipes = responseEntity.getBody().getRecipes();
      if (recipes != null) {
        log.info("recipes fetched successfully");
        recipeService.saveAll(recipes);
      }
    }
  }
}
