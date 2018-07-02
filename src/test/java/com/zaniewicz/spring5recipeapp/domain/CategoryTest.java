package com.zaniewicz.spring5recipeapp.domain;

import lombok.val;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CategoryTest {

    private Category category;

    @Before
    public void setUp() {
        category = new Category();
    }

    @Test
    public void getId() {
        val id = 4L;
        category.setId(id);
        assertThat(category.getId()).isEqualTo(id);
    }

    @Test
    public void getDescription() {
        val description = "some description";
        category.setDescription(description);
        assertThat(category.getDescription()).isEqualTo(description);
    }
}