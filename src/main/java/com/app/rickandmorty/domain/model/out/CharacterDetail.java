package com.app.rickandmorty.domain.model.out;

import com.app.rickandmorty.domain.model.in.Location;
import com.app.rickandmorty.domain.model.in.Character;
import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CharacterDetail {

    public CharacterDetail(Character character, Location location){

        assert character != null;
        assert location != null;

        this.id = character.getId();
        this.name = character.getName();
        this.status = character.getStatus();
        this.species = character.getSpecies();
        this.type = character.getType();
        this.episodeCount = character.getEpisode().size();
        this.originDetail = OriginDetail.builder()
                .dimension(location.getDimension())
                .name(location.getName())
                .residents(location.getResidents())
                .url(location.getUrl())
                .build();
    }

    public CharacterDetail(Character character){

        assert character != null;

        this.id = character.getId();
        this.name = character.getName();
        this.status = character.getStatus();
        this.species = character.getSpecies();
        this.type = character.getType();
        this.episodeCount = character.getEpisode().size();

    }

    private int id;
    private String name;
    private String status;
    private String species;
    private String type;
    @JsonAlias("episode_count")
    private int episodeCount;
    private OriginDetail originDetail;
}
