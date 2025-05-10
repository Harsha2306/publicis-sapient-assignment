package com.harsha.backend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Recipe {
  @Id private Integer id;
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
