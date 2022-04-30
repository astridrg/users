package com.app.rickandmorty.domain.service;

import com.app.rickandmorty.domain.model.out.CharacterDetail;
import com.app.rickandmorty.domain.model.in.Origin;
import com.app.rickandmorty.domain.port.in.RickAndMortyDataSource;
import com.app.rickandmorty.domain.util.exception.ResourceNotFoundException;
import com.app.rickandmorty.util.Mocks;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.*;

@SpringBootTest
public class ServiceTest {

    @MockBean
    private RickAndMortyDataSource dataSource;

    private Service service;

    @BeforeEach
    public void setUp(){
        service = new Service(dataSource);
    }

    @Test
    public void testGetCharacterOk(){
        Mockito.when(dataSource.getCharacter(anyInt())).thenReturn(Optional.of(Mocks.getCharacterMock()));
        Mockito.when(dataSource.getLocation(anyString())).thenReturn(Optional.of(Mocks.getLocationMock()));
        CharacterDetail characterDetail = service.getCharacterDetail(1);
        Assertions.assertNotNull(characterDetail);
        Assertions.assertTrue(characterDetail.getId() > 0);
        Assertions.assertNotNull(characterDetail.getOriginDetail());
        Assertions.assertNotNull(characterDetail.getOriginDetail().getResidents());
        Assertions.assertTrue(characterDetail.getOriginDetail().getResidents().size() > 0);
    }

    @Test
    public void testGetCharacterDetailCharacterEmpty(){
        Mockito.when(dataSource.getCharacter(anyInt())).thenReturn(Optional.empty());
        Assertions.assertThrowsExactly(ResourceNotFoundException.class, () -> service.getCharacterDetail(1));
    }

    @Test
    public void testGetCharacterDetailOriginNull(){
        Mockito.when(dataSource.getCharacter(anyInt())).thenReturn(Optional.of(Mocks.getCharacterMock().toBuilder().origin(null).build()));

        CharacterDetail characterDetail = service.getCharacterDetail(1);
        Assertions.assertNotNull(characterDetail);
        Assertions.assertTrue(characterDetail.getId() > 0);
        Assertions.assertNull(characterDetail.getOriginDetail());
    }

    @Test
    public void testGetCharacterDetailOriginUrlEmpty(){
        Mockito.when(dataSource.getCharacter(anyInt())).thenReturn(Optional.of(Mocks.getCharacterMock().toBuilder().origin(Origin.builder().build()).build()));

        CharacterDetail characterDetail = service.getCharacterDetail(1);
        Assertions.assertNotNull(characterDetail);
        Assertions.assertTrue(characterDetail.getId() > 0);
        Assertions.assertNull(characterDetail.getOriginDetail());
    }

    @Test
    public void testGetCharacterDetailOriginBadUrl(){
        Mockito.when(dataSource.getCharacter(anyInt())).thenReturn(Optional.of(Mocks.getCharacterMock().toBuilder().origin(Origin.builder().url("url").build()).build()));
        CharacterDetail characterDetail = service.getCharacterDetail(1);
        Assertions.assertNotNull(characterDetail);
        Assertions.assertTrue(characterDetail.getId() > 0);
        Assertions.assertNull(characterDetail.getOriginDetail());
    }

    @Test
    public void testGetCharacterDetailLocationEmpty(){
        Mockito.when(dataSource.getCharacter(anyInt())).thenReturn(Optional.of(Mocks.getCharacterMock()));
        Mockito.when(dataSource.getLocation(anyString())).thenReturn(Optional.empty());
        CharacterDetail characterDetail = service.getCharacterDetail(1);
        Assertions.assertNotNull(characterDetail);
        Assertions.assertTrue(characterDetail.getId() > 0);
        Assertions.assertNull(characterDetail.getOriginDetail());
    }

}
