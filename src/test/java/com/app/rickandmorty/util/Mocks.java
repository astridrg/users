package com.app.rickandmorty.util;

import com.app.rickandmorty.domain.model.out.CharacterDetail;
import com.app.rickandmorty.domain.model.in.Character;
import com.app.rickandmorty.domain.model.in.Location;
import com.app.rickandmorty.domain.model.in.LocationCharacter;
import com.app.rickandmorty.domain.model.in.Origin;

import java.time.LocalDate;
import java.util.List;

public class Mocks {

    public static Character getCharacterMock(){

        return Character.builder()
                .locationCharacter(LocationCharacter.builder().name("test").url("http://test.rest").build())
                .created(LocalDate.now())
                .episode(List.of("test1", "test2"))
                .gender("test")
                .id(1)
                .image("test")
                .name("test")
                .origin(Origin.builder().name("test").url("https://test.test").build())
                .species("test")
                .status("test")
                .type("test")
                .url("test")
                .build();
    }

    public static Location getLocationMock(){
        return Location.builder()
                .created(LocalDate.now())
                .id(1)
                .dimension("test")
                .name("test")
                .url("https://test.test")
                .type("test")
                .residents(List.of("test1","test2"))
                .build();
    }

    public static CharacterDetail getCharacterDetailMock() {
        return new CharacterDetail(getCharacterMock(), getLocationMock());
    }
}
