package com.zaniewicz.spring5recipeapp.mapper;

import com.zaniewicz.spring5recipeapp.domain.Note;
import com.zaniewicz.spring5recipeapp.domain.dto.NotesDto;
import org.springframework.stereotype.Component;

@Component
public class NoteMapper {

    public Note mapToNote(NotesDto notesDto) {
        if (notesDto == null) {
            return null;
        }

        return Note.builder()
                .id(notesDto.getId())
                .recipeNote(notesDto.getRecipeNote())
                .build();
    }
}
