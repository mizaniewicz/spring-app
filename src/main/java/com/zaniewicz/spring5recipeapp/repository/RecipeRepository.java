package com.zaniewicz.spring5recipeapp.repository;

import com.zaniewicz.spring5recipeapp.domain.Recipe;
import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {
}
