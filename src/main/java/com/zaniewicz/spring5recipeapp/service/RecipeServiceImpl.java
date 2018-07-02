package com.zaniewicz.spring5recipeapp.service;

import com.zaniewicz.spring5recipeapp.domain.Recipe;
import com.zaniewicz.spring5recipeapp.domain.dto.RecipeDto;
import com.zaniewicz.spring5recipeapp.mapper.RecipeMapper;
import com.zaniewicz.spring5recipeapp.repository.RecipeRepository;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Slf4j
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository recipeRepository;
    private final RecipeMapper recipeMapper;

    public RecipeServiceImpl(RecipeRepository recipeRepository, RecipeMapper recipeMapper) {
        this.recipeRepository = recipeRepository;
        this.recipeMapper = recipeMapper;
    }

    @Override
    public Set<Recipe> getRecipes() {
        log.info("I'm in the service");
        Set<Recipe> recipes = new HashSet<>();
        recipeRepository.findAll().forEach(recipes::add);
        return recipes;
    }

    @Override
    public Recipe findById(Long id) {
        val recipeOptional = recipeRepository.findById(id);
        if (!recipeOptional.isPresent()) throw new RuntimeException(String.format("Recipe with id %d not found", id));
        return recipeOptional.get();
    }

    @Override
    public RecipeDto saveRecipeDto(RecipeDto recipeDto) {
        val recipe = recipeMapper.mapToRecipe(recipeDto);
        val savedRecipe = recipeRepository.save(recipe);
        log.debug("Saved recipe Id" + savedRecipe.getId());
        return recipeMapper.mapToRecipeDto(savedRecipe);
    }
}
