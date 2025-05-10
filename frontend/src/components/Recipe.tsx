import React, { useEffect } from "react";

import { useParams } from "react-router";
import type { Recipe } from "../types";

const Recipe = () => {
  const [recipe, setRecipe] = React.useState<Recipe | null>(null);
  const { id } = useParams<{ id: string }>();

  useEffect(() => {
    const fetchRecipe = async () => {
      try {
        const response = await fetch(`http://localhost:8080/recipes/${id}`);
        if (!response.ok) {
          throw new Error("Network response was not ok");
        }
        const data = await response.json();
        setRecipe(data);
      } catch (error) {
        console.error("Error fetching recipe:", error);
      }
    };
    fetchRecipe();
  }, [id]);

  if (!recipe) {
    return <div>Loading...</div>;
  }

  const {
    name,
    cuisine,
    prepTimeMinutes,
    cookTimeMinutes,
    ingredients,
    instructions,
  } = recipe;

  return (
    <div>
      <h1>{name}</h1>
      <p>Cuisine: {cuisine}</p>
      <p>Prep Time: {prepTimeMinutes} minutes</p>
      <p>Cook Time: {cookTimeMinutes} minutes</p>
      <h2>Ingredients</h2>
      <ul>
        {ingredients.map((ingredient, index) => (
          <li key={index}>{ingredient}</li>
        ))}
      </ul>
      <h2>Instructions</h2>
      <ol>
        {instructions.map((instruction, index) => (
          <li key={index}>{instruction}</li>
        ))}
      </ol>
    </div>
  );
};

export default Recipe;