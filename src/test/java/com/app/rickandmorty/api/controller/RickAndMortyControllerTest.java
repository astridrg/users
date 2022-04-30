package com.app.rickandmorty.api.controller;

import com.app.rickandmorty.domain.model.out.CharacterDetail;
import com.app.rickandmorty.domain.port.out.ServicePort;
import com.app.rickandmorty.domain.util.exception.ResourceNotFoundException;
import com.app.rickandmorty.util.Mocks;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(RickAndMortyController.class)
public class RickAndMortyControllerTest {

    @Autowired
    private MockMvc mock;

    @Autowired
    private ObjectMapper mapper;

    @MockBean
    private ServicePort service;

    private static final String BASE_PATH = "/character";

    private static final String GET_CHARACTER_DETAIL = BASE_PATH.concat("/detail/?");


    @Test
    public void testGetCharacterDetailOk() throws Exception {

        Mockito.when(service.getCharacterDetail(anyInt())).thenReturn(Mocks.getCharacterDetailMock());

        MvcResult result = mock.perform(
                MockMvcRequestBuilders.get(GET_CHARACTER_DETAIL.replace("?", "1"))

        ).andExpect(status().isOk()).andReturn();

        String resultSS = result.getResponse().getContentAsString();
        CharacterDetail characterDetail = mapper.readValue(resultSS, CharacterDetail.class);

        Assertions.assertNotNull(characterDetail);
        Assertions.assertTrue(characterDetail.getId() > 0);
    }

    @Test
    public void testNotFoundException() throws Exception {

        Mockito.when(service.getCharacterDetail(anyInt())).thenThrow(ResourceNotFoundException.class);

        mock.perform(
                MockMvcRequestBuilders.get(GET_CHARACTER_DETAIL.replace("?", "1"))
        ).andExpect(status().isNotFound());
    }

}
