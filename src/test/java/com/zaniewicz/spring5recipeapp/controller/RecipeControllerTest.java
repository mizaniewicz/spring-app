package com.zaniewicz.spring5recipeapp.controller;

import com.zaniewicz.spring5recipeapp.domain.Recipe;
import com.zaniewicz.spring5recipeapp.service.RecipeService;
import lombok.val;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class RecipeControllerTest {

    RecipeController controller;

    @Mock
    RecipeService service;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        controller = new RecipeController(service);
    }

    @Test
    public void getRecipeById() throws Exception {
        val recipe = new Recipe();
        recipe.setId(1L);

        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();

        when(service.findById(anyLong())).thenReturn(recipe);

        mockMvc.perform(get("/recipe/show/1"))
                .andExpect(status().isOk())
                .andExpect(view().name("recipe/show"))
                .andExpect(model().attributeExists("recipe"));
    }
}