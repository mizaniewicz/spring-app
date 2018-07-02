package com.zaniewicz.spring5recipeapp.mapper;

import com.zaniewicz.spring5recipeapp.domain.dto.CategoryDto;
import lombok.val;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CategoryMapperTest {

    CategoryMapper mapper;

    @Before
    public void setUp() throws Exception {
        mapper = new CategoryMapper();
    }

    @Test
    public void testNullParameter() {
        assertThat(mapper.mapToCategory(null)).isNull();
    }

    @Test
    public void testEmptyObject() {
        assertThat(mapper.mapToCategory(new CategoryDto())).isNotNull();
    }

    @Test
    public void testMapToCategory() {
        val dto = CategoryDto.builder()
                .id(1L)
                .description("test")
                .build();

        val result = mapper.mapToCategory(dto);

        assertThat(result.getId()).isEqualTo(dto.getId());
        assertThat(result.getDescription()).isEqualTo(dto.getDescription());
    }
}