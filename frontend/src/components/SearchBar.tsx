import React from "react";
import type { Recipe } from "../types";
import axios from "axios";

type SearchBarProps = {
  setRecipes: React.Dispatch<React.SetStateAction<Recipe[]>>;
};

const SearchBar: React.FC<SearchBarProps> = ({ setRecipes }) => {
  const [searchForm, setSearchForm] = React.useState({
    name: "",
    cuisine: "",
  });

  const handleChange = (e: React.ChangeEvent<HTMLInputElement>) => {
    const { name, value } = e.target;
    setSearchForm((prev) => ({
      ...prev,
      [name]: value,
    }));
  };

  const handleSubmit = (e: React.FormEvent<HTMLFormElement>) => {
    e.preventDefault();
    try {
      axios
        .get(`http://localhost:8080/recipes`, {
          params: {
            name: searchForm.name,
            cuisine: searchForm.cuisine,
          },
        })
        .then((response) => {
          setRecipes(response.data);
        });
    } catch (error) {
      console.error("Error fetching recipes:", error);
    }
  };

  return (
    <form onSubmit={(e) => handleSubmit(e)}>
      <label htmlFor="name" />
      <input
        type="text"
        id="name"
        name="name"
        placeholder="Search for Names"
        value={searchForm.name}
        onChange={(e) => handleChange(e)}
      />
      <label htmlFor="cuisime" />
      <input
        type="text"
        id="cuisime"
        name="cuisine"
        placeholder="Search for Cuisines"
        value={searchForm.cuisine}
        onChange={(e) => handleChange(e)}
      />
      <button type="submit">Search</button>
    </form>
  );
};

export default SearchBar;
