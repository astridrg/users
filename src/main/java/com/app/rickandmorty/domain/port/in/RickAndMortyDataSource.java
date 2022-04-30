package com.app.rickandmorty.domain.port.in;

import com.app.rickandmorty.domain.model.in.Character;
import com.app.rickandmorty.domain.model.in.Location;

import java.util.Optional;

public interface RickAndMortyDataSource {
    Optional<Character> getCharacter(int id);

    Optional<Location> getLocation(String url);
}
