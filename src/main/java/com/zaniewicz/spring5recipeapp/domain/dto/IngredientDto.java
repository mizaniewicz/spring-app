package com.zaniewicz.spring5recipeapp.domain.dto;

import com.zaniewicz.spring5recipeapp.domain.UnitOfMeasure;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class IngredientDto {

    private Long Id;
    private String description;
    private BigDecimal amount;
    private UnitOfMeasure unitOfMeasure;
}
