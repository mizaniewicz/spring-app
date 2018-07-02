package com.zaniewicz.spring5recipeapp.mapper;

import com.zaniewicz.spring5recipeapp.domain.Ingredient;
import com.zaniewicz.spring5recipeapp.domain.dto.IngredientDto;
import org.springframework.stereotype.Component;

@Component
public class IngredientMapper {

    public Ingredient mapToIngredient(IngredientDto ingredientDto) {
        if (ingredientDto == null) {
            return null;
        }

        return Ingredient.builder()
                .id(ingredientDto.getId())
                .description(ingredientDto.getDescription())
                .amount(ingredientDto.getAmount())
//                .unitOfMeasure()
                .build();
    }
}
