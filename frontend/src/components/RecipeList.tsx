import React from "react";
import type { Recipe } from "../types";
import { useNavigate } from "react-router";

type RecipeListProps = {
  recipes: Recipe[];
};

const RecipeList: React.FC<RecipeListProps> = ({ recipes }) => {
  return (
    <>
      {recipes.map((recipe) => (
        <RecipeItem recipe={recipe} key={recipe.id} />
      ))}
    </>
  );
};

const RecipeItem: React.FC<{ recipe: Recipe }> = ({ recipe }) => {
  const navigate = useNavigate();

  const handleClick = () => {
    navigate(`/recipe/${recipe.id}`);
  };

  return (
    <div
      onClick={handleClick}
      style={{
        cursor: "pointer",
        border: "1px solid #ccc",
        padding: "10px",
        margin: "10px 0",
      }}
    >
      <h3>{recipe.name}</h3>
      <p>{recipe.cuisine}</p>
      <p>Prep Time: {recipe.prepTimeMinutes} minutes</p>
      <p>Cook Time: {recipe.cookTimeMinutes} minutes</p>
    </div>
  );
};

export default RecipeList;
