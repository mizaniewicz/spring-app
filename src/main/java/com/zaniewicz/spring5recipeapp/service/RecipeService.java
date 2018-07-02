package com.zaniewicz.spring5recipeapp.service;

import com.zaniewicz.spring5recipeapp.domain.Recipe;
import com.zaniewicz.spring5recipeapp.domain.dto.RecipeDto;

import java.util.Set;

public interface RecipeService {

    Set<Recipe> getRecipes();
    Recipe findById(Long id);
    RecipeDto saveRecipeDto(RecipeDto recipeDto);
}
