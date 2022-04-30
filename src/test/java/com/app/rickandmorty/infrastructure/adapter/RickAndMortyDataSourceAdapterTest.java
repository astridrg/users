package com.app.rickandmorty.infrastructure.adapter;

import com.app.rickandmorty.domain.model.in.Character;
import com.app.rickandmorty.domain.model.in.Location;
import com.app.rickandmorty.util.Mocks;
import com.app.rickandmorty.infrastructure.provider.externalservice.RickAndMortyService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.anyInt;

public class RickAndMortyDataSourceAdapterTest {


    private RickAndMortyService service;

    private RickAndMortyDataSourceAdapter rickAndMortyDataSourceAdapter;

    @BeforeEach
    public void setUp() {
        service = Mockito.mock(RickAndMortyService.class);
        rickAndMortyDataSourceAdapter = new RickAndMortyDataSourceAdapter(service);
    }

    @Test
    public void getCharacterTest() {
        Mockito.when(service.getCharacter(anyInt())).thenReturn(Optional.of(Mocks.getCharacterMock()));
        Optional<Character> characterResp = rickAndMortyDataSourceAdapter.getCharacter(1);
        Assertions.assertTrue(characterResp.isPresent());
        Assertions.assertTrue(characterResp.get().getId() > 0);
    }

    @Test
    public void getLocationTest() {
        Mockito.when(service.getLocation(anyString())).thenReturn(Optional.of(Mocks.getLocationMock()));
        Optional<Location> locationResp = rickAndMortyDataSourceAdapter.getLocation("test");
        Assertions.assertTrue(locationResp.isPresent());
        Assertions.assertTrue(locationResp.get().getId() > 0);
    }
}
