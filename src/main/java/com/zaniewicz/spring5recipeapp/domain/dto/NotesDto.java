package com.zaniewicz.spring5recipeapp.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NotesDto {

    private Long id;
    private String recipeNote;
}
