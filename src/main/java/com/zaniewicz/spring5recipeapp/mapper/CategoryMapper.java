package com.zaniewicz.spring5recipeapp.mapper;

import com.zaniewicz.spring5recipeapp.domain.Category;
import com.zaniewicz.spring5recipeapp.domain.dto.CategoryDto;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper {

    public Category mapToCategory(CategoryDto categoryDto) {
        if (categoryDto == null) {
            return null;
        }
        return Category.builder()
                .id(categoryDto.getId())
                .description(categoryDto.getDescription())
                .build();
    }
}
