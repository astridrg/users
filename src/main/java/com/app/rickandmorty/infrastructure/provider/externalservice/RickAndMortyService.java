package com.app.rickandmorty.infrastructure.provider.externalservice;

import com.app.rickandmorty.domain.util.Util;
import com.app.rickandmorty.domain.model.in.Character;
import com.app.rickandmorty.domain.model.in.Location;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import java.util.Optional;

@Component
@Slf4j
public class RickAndMortyService {


    private String host;

    private String pathCharacter;

    private String pathLocation;

    private RestTemplate restTemplate;

    public RickAndMortyService(RestTemplate restTemplate,
                               @Value("${external.service.host}") String host,
                               @Value("${external.service.path.character}") String pathCharacter,
                               @Value("${external.service.path.location}") String pathLocation){
        this.pathLocation = pathLocation;
        this.pathCharacter = pathCharacter;
        this.host = host;
        this.restTemplate = restTemplate;
    }

    public Optional<Character> getCharacter(Integer id){

        assert id > 0;
        log.info("execute RickAndMortyService.getCharacter("+id+")");
        ResponseEntity<Character> response = restTemplate.getForEntity(host.concat(pathCharacter).concat(id.toString()), Character.class);

        return Optional.ofNullable(response.getBody());
    }

    public Optional<Location> getLocation(Integer id){

        assert id > 0;
        log.info("execute RickAndMortyService.getLocation("+id+")");
        ResponseEntity<Location> response = restTemplate.getForEntity(host.concat(pathLocation).concat(id.toString()), Location.class);

        return Optional.ofNullable(response.getBody());
    }

    public Optional<Location> getLocation(String url){
        assert Util.urlValidator(url);
        assert url.contains(pathLocation);

        log.info("execute RickAndMortyService.getLocation("+url+")");
        ResponseEntity<Location> response = restTemplate.getForEntity(url, Location.class);

        return Optional.ofNullable(response.getBody());
    }

}
