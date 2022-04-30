package com.app.rickandmorty.api.controller;

import com.app.rickandmorty.domain.model.out.CharacterDetail;
import com.app.rickandmorty.domain.port.out.ServicePort;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/character")
@OpenAPIDefinition(
        info = @Info(
                title = "Rick and Morty Api",
                version = "1.0"
        )
)
@Slf4j
@Validated
public class RickAndMortyController {

    private ServicePort servicePort;

    RickAndMortyController(ServicePort servicePort){
        this.servicePort = servicePort;
    }

    @GetMapping(path = "/detail/{id}")
    @Operation(summary = "Return character detail")
    ResponseEntity<CharacterDetail> getCharacterDetail(@PathVariable int id) {
        log.info("execute RickAndMortyController.getCharacterDetail("+id+")");
        CharacterDetail response = servicePort.getCharacterDetail(id);
        return ResponseEntity.ok(response);
    }
}
