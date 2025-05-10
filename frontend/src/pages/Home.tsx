import React, { useState } from "react";
import SearchBar from "../components/SearchBar";
import RecipeList from "../components/RecipeList";
import type { Recipe } from "../types";

const Home: React.FC = () => {
  const [recipes, setRecipes] = useState<Recipe[]>([]);
  const [sortOrder, setSortOrder] = useState<"asc" | "desc">("asc");

  const handleSort = () => {
    const sortedRecipes = [...recipes].sort((a, b) => {
      if (sortOrder === "asc") {
        return a.cookTimeMinutes - b.cookTimeMinutes;
      } else {
        return b.cookTimeMinutes - a.cookTimeMinutes;
      }
    });
    setRecipes(sortedRecipes);
    setSortOrder(sortOrder === "asc" ? "desc" : "asc");
  };

  return (
    <>
      <SearchBar setRecipes={setRecipes} />
      <br />
      <button onClick={handleSort}>
        Click to sort by cookTimeMinutes {sortOrder === "asc" ? "ASC" : "DSC"}
      </button>
      <h1>Recipe List</h1>
      <RecipeList recipes={recipes} />
    </>
  );
};

export default Home;
