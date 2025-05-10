package com.harsha.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecipesFromAPIDto {
  private List<RecipeFromAPIItemDto> recipes;
  private Integer total;
  private Integer skip;
  private Integer limit;
}
