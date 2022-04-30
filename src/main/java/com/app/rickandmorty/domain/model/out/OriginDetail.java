package com.app.rickandmorty.domain.model.out;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class OriginDetail {
    private String name;
    private String url;
    private String dimension;
    private List<String> residents;
}

