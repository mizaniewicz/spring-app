package com.zaniewicz.spring5recipeapp.service;

import com.zaniewicz.spring5recipeapp.domain.Recipe;
import com.zaniewicz.spring5recipeapp.mapper.RecipeMapper;
import com.zaniewicz.spring5recipeapp.repository.RecipeRepository;
import lombok.val;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class RecipeServiceImplTest {

    RecipeService recipeService;

    @Mock
    RecipeRepository recipeRepository;

    @Mock
    RecipeMapper recipeMapper;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        recipeService = new RecipeServiceImpl(recipeRepository, recipeMapper);
    }

    @Test
    public void getRecipeByID() {
        Recipe recipe = new Recipe();
        recipe.setId(1L);
        val recipeOptional = Optional.of(recipe);

        when(recipeRepository.findById(anyLong())).thenReturn(recipeOptional);

        val result = recipeService.findById(1L);

        assertThat(result).isNotNull();
        verify(recipeRepository, times(1)).findById(anyLong());
    }

    @Test
    public void getRecipes() {
        val recipe = new Recipe();
        Set recipeData = new HashSet();
        recipeData.add(recipe);

        when(recipeService.getRecipes()).thenReturn(recipeData);

        Set<Recipe> recipes = recipeService.getRecipes();

        assertThat(recipes.size()).isEqualTo(1);
        verify(recipeRepository, times(1)).findAll();
    }
}