package com.harsha.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecipeFromAPIItemDto {
  private Integer id;
  private String name;
  private List<String> ingredients;
  private List<String> instructions;
  private Integer prepTimeMinutes;
  private Integer cookTimeMinutes;
  private Integer servings;
  private String difficulty;
  private String cuisine;
  private Integer caloriesPerServing;
  private List<String> tags;
  private Integer userId;
  private String image;
  private Double rating;
  private Integer reviewCount;
  private List<String> mealType;
}
