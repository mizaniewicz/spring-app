package com.zaniewicz.spring5recipeapp.domain.dto;

import com.zaniewicz.spring5recipeapp.domain.Difficulty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class RecipeDto {

    private Long id;
    private String description;
    private Integer prepTime;
    private Integer cookTime;
    private Integer servings;
    private String source;
    private String url;
    private String directions;
    private Byte[] image;
    private Difficulty difficulty;
    private NotesDto note;
    private Set<IngredientDto> ingredients = new HashSet<>();
    private Set<CategoryDto> categories = new HashSet<>();
}
