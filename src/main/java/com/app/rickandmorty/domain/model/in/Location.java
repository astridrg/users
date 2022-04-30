package com.app.rickandmorty.domain.model.in;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Location {
    private int id;
    private String name;
    private String type;
    private String dimension;
    private List<String> residents;
    private String url;
    private LocalDate created;
}
