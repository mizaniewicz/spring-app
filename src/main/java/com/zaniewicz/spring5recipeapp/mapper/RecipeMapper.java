package com.zaniewicz.spring5recipeapp.mapper;

import com.zaniewicz.spring5recipeapp.domain.Recipe;
import com.zaniewicz.spring5recipeapp.domain.dto.RecipeDto;
import lombok.val;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class RecipeMapper {

    private CategoryMapper categoryMapper;

    private NoteMapper noteMapper;

    public RecipeMapper(CategoryMapper categoryMapper, NoteMapper noteMapper) {
        this.categoryMapper = categoryMapper;
        this.noteMapper = noteMapper;
    }

    public Recipe mapToRecipe(RecipeDto recipeDto) {
        if (recipeDto == null) {
            return null;
        }

//        val ingredients = recipeDto.getIngredients().stream()
//                .map(ingredientDto -> ingredientMapper.mapToIngredient(ingredientDto))
//                .collect(Collectors.toSet());

        val categories = recipeDto.getCategories().stream()
                .map(categoryDto -> categoryMapper.mapToCategory(categoryDto))
                .collect(Collectors.toSet());


        val recipe = Recipe.builder()
                .id(recipeDto.getId())
                .description(recipeDto.getDescription())
                .preparationTime(recipeDto.getPrepTime())
                .cookTime(recipeDto.getCookTime())
                .servings(recipeDto.getServings())
                .source(recipeDto.getSource())
                .url(recipeDto.getUrl())
                .directions(recipeDto.getDirections())
                .difficulty(recipeDto.getDifficulty())
                .note(noteMapper.mapToNote(recipeDto.getNote()))
//                .ingredients(recipeDto.getIngredients())
                .categories(categories)
                .build();

        return recipe;
    }

    public RecipeDto mapToRecipeDto(Recipe recipe) {
        return null;
    }
}
