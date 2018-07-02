package com.zaniewicz.spring5recipeapp.domain;

import lombok.*;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor@EqualsAndHashCode(exclude = "recipe")
@Entity
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    private String recipeNote;

    @OneToOne
    private Recipe recipe;
}
