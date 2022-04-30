package com.app.rickandmorty.infrastructure.adapter;

import com.app.rickandmorty.domain.port.in.RickAndMortyDataSource;
import com.app.rickandmorty.infrastructure.provider.externalservice.RickAndMortyService;
import com.app.rickandmorty.domain.model.in.Character;
import com.app.rickandmorty.domain.model.in.Location;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Slf4j
public class RickAndMortyDataSourceAdapter implements RickAndMortyDataSource {

    private RickAndMortyService service;

    RickAndMortyDataSourceAdapter(RickAndMortyService service){
        this.service = service;
    }

    @Override
    public Optional<Character> getCharacter(int id) {
        log.info("execute RickAndMortyDaraSourceAdapter.getCharacter("+id+")");
        return service.getCharacter(id);
    }

    @Override
    public Optional<Location> getLocation(String url) {
        log.info("execute RickAndMortyDaraSourceAdapter.getLocation("+url+")");
        return service.getLocation(url);
    }

}
