package com.app.rickandmorty.domain.service;

import com.app.rickandmorty.domain.model.out.CharacterDetail;
import com.app.rickandmorty.domain.port.in.RickAndMortyDataSource;
import com.app.rickandmorty.domain.port.out.ServicePort;
import com.app.rickandmorty.domain.util.Util;
import com.app.rickandmorty.domain.util.exception.ResourceNotFoundException;
import com.app.rickandmorty.domain.model.in.Character;
import com.app.rickandmorty.domain.model.in.Location;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Slf4j
public class Service implements ServicePort {

    private RickAndMortyDataSource dataSource;

    Service(RickAndMortyDataSource dataSource){
        this.dataSource = dataSource;
    }

    @Override
    public CharacterDetail getCharacterDetail(int id) {
        log.info("execute Service.getCharacterDetail("+id+")");
        Optional<Character> character = dataSource.getCharacter(id);
        if (character.isEmpty()){
            throw new ResourceNotFoundException("Character not found");
        }

        Optional<Location> location = validAndGetLocation(character.get());

        if (location.isEmpty()){
            return new CharacterDetail(character.get());
        }

        return new CharacterDetail(character.get(), location.get());
    }

    private Optional<Location> validAndGetLocation(Character character){

        if (character.getOrigin() != null
                && character.getOrigin().getUrl() != null
                && !character.getOrigin().getUrl().isBlank()
                && Util.urlValidator(character.getOrigin().getUrl())
        ) {
            return dataSource.getLocation(character.getOrigin().getUrl());
        }

        return Optional.empty();
    }
}
