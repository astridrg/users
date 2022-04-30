package com.app.rickandmorty.domain.model.in;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Builder(toBuilder=true)
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Character {
    private int id;
    private String name;
    private String status;
    private String species;
    private String type;
    private String gender;
    private Origin origin;
    private LocationCharacter locationCharacter;
    private String image;
    private List<String> episode;
    private String url;
    private LocalDate created;
}
