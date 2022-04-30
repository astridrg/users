package com.app.rickandmorty.infrastructure.provider.externalservice;

import com.app.rickandmorty.domain.model.in.Character;
import com.app.rickandmorty.domain.model.in.Location;
import com.app.rickandmorty.util.Mocks;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.client.ExpectedCount;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.test.web.client.response.MockRestResponseCreators;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Optional;

@SpringBootTest
@ActiveProfiles("test")
public class RickAndMortyServiceTest {

    @Autowired
    private RickAndMortyService rickAndMortyService;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ObjectMapper mapper;

    private MockRestServiceServer mockServer;

    @BeforeEach
    public void setUp(){
        mockServer = MockRestServiceServer.createServer(restTemplate);
    }

    @Test
    public void getCharacterOk() throws JsonProcessingException, URISyntaxException {

        Character characterMock = Mocks.getCharacterMock();

        String body = mapper.writeValueAsString(characterMock);

        mockServer.expect(ExpectedCount.once(),
                        requestTo(new URI("https://test.test/api/character/1")))
                .andExpect(method(HttpMethod.GET))
                .andRespond(MockRestResponseCreators.withStatus(HttpStatus.OK)
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(body)
                );

        Optional<Character> characterRespService = rickAndMortyService.getCharacter(1);
        mockServer.verify();
        Assertions.assertEquals(characterMock.getCreated(), characterRespService.get().getCreated());


    }

    @Test
    public void getCharacterIdSmallerThanOne() {
        Assertions.assertThrowsExactly(AssertionError.class, () -> rickAndMortyService.getCharacter(0));
        Assertions.assertThrowsExactly(AssertionError.class, () -> rickAndMortyService.getCharacter(-1));
    }

    @Test
    public void getCharacter404() throws JsonProcessingException, URISyntaxException {

        mockServer.expect(ExpectedCount.once(),
                        requestTo(new URI("https://test.test/api/character/1")))
                .andExpect(method(HttpMethod.GET))
                .andRespond(MockRestResponseCreators.withStatus(HttpStatus.NOT_FOUND)
                        .contentType(MediaType.APPLICATION_JSON)
                        .body("{\"error\": \"Character not found\"}")
                );

        Optional<Character> characterRespService = rickAndMortyService.getCharacter(1);
        mockServer.verify();
        Assertions.assertTrue(characterRespService.isEmpty());
    }

    @Test
    public void getCharacter500() throws JsonProcessingException, URISyntaxException {

        mockServer.expect(ExpectedCount.once(),
                        requestTo(new URI("https://test.test/api/character/1")))
                .andExpect(method(HttpMethod.GET))
                .andRespond(MockRestResponseCreators.withStatus(HttpStatus.INTERNAL_SERVER_ERROR)
                        .contentType(MediaType.APPLICATION_JSON)
                        .body("{\"error\": \"Hey! you must provide an id\"}")
                );

        Optional<Character> characterRespService = rickAndMortyService.getCharacter(1);
        mockServer.verify();
        Assertions.assertTrue(characterRespService.isEmpty());
    }

    @Test
    public void getLocationOk() throws JsonProcessingException, URISyntaxException {
        Location locationMock = Mocks.getLocationMock();

        String body = mapper.writeValueAsString(locationMock);

        mockServer.expect(ExpectedCount.once(),
                        requestTo(new URI("https://test.test/api/location/1")))
                .andExpect(method(HttpMethod.GET))
                .andRespond(MockRestResponseCreators.withStatus(HttpStatus.OK)
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(body)
                );

        Optional<Location> locationRespService = rickAndMortyService.getLocation(1);
        mockServer.verify();
        Assertions.assertEquals(locationMock.getCreated(), locationRespService.get().getCreated());


    }

    @Test
    public void getLocationIdSmallerThanOne() {
        Assertions.assertThrowsExactly(AssertionError.class, () -> rickAndMortyService.getLocation(0));
        Assertions.assertThrowsExactly(AssertionError.class, () -> rickAndMortyService.getLocation(-1));
    }

    @Test
    public void getLocation404() throws JsonProcessingException, URISyntaxException {

        mockServer.expect(ExpectedCount.once(),
                        requestTo(new URI("https://test.test/api/location/1")))
                .andExpect(method(HttpMethod.GET))
                .andRespond(MockRestResponseCreators.withStatus(HttpStatus.NOT_FOUND)
                        .contentType(MediaType.APPLICATION_JSON)
                        .body("{\"error\": \"Location not found\"}")
                );

        Optional<Location> locationRespService = rickAndMortyService.getLocation(1);
        mockServer.verify();
        Assertions.assertTrue(locationRespService.isEmpty());
    }

    @Test
    public void getLocation500() throws JsonProcessingException, URISyntaxException {

        mockServer.expect(ExpectedCount.once(),
                        requestTo(new URI("https://test.test/api/location/1")))
                .andExpect(method(HttpMethod.GET))
                .andRespond(MockRestResponseCreators.withStatus(HttpStatus.INTERNAL_SERVER_ERROR)
                        .contentType(MediaType.APPLICATION_JSON)
                        .body("{\"error\": \"Hey! you must provide an id\"}")
                );

        Optional<Location> locationRespService = rickAndMortyService.getLocation(1);
        mockServer.verify();
        Assertions.assertTrue(locationRespService.isEmpty());
    }

    @Test
    public void getLocationStringOk() throws JsonProcessingException, URISyntaxException {
        Location locationMock = Mocks.getLocationMock();

        String body = mapper.writeValueAsString(locationMock);

        mockServer.expect(ExpectedCount.once(),
                        requestTo(new URI("https://test.test/api/location/1")))
                .andExpect(method(HttpMethod.GET))
                .andRespond(MockRestResponseCreators.withStatus(HttpStatus.OK)
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(body)
                );

        Optional<Location> locationRespService = rickAndMortyService.getLocation("https://test.test/api/location/1");
        mockServer.verify();
        Assertions.assertEquals(locationMock.getCreated(), locationRespService.get().getCreated());


    }

    @Test
    public void getLocationStringExceptionUrl() {
        Assertions.assertThrowsExactly(AssertionError.class, () -> rickAndMortyService.getLocation("0"));
        Assertions.assertThrowsExactly(AssertionError.class, () -> rickAndMortyService.getLocation("https://www.google.com/"));
        Assertions.assertThrowsExactly(AssertionError.class, () -> rickAndMortyService.getLocation("0"));
        Assertions.assertThrowsExactly(AssertionError.class, () -> rickAndMortyService.getLocation(""));
    }

    @Test
    public void getLocationString404() throws JsonProcessingException, URISyntaxException {

        mockServer.expect(ExpectedCount.once(),
                        requestTo(new URI("https://test.test/api/location/1")))
                .andExpect(method(HttpMethod.GET))
                .andRespond(MockRestResponseCreators.withStatus(HttpStatus.NOT_FOUND)
                        .contentType(MediaType.APPLICATION_JSON)
                        .body("{\"error\": \"Location not found\"}")
                );

        Optional<Location> locationRespService = rickAndMortyService.getLocation("https://test.test/api/location/1");
        mockServer.verify();
        Assertions.assertTrue(locationRespService.isEmpty());
    }

    @Test
    public void getLocationString500() throws JsonProcessingException, URISyntaxException {

        mockServer.expect(ExpectedCount.once(),
                        requestTo(new URI("https://test.test/api/location/1")))
                .andExpect(method(HttpMethod.GET))
                .andRespond(MockRestResponseCreators.withStatus(HttpStatus.INTERNAL_SERVER_ERROR)
                        .contentType(MediaType.APPLICATION_JSON)
                        .body("{\"error\": \"Hey! you must provide an id\"}")
                );

        Optional<Location> locationRespService = rickAndMortyService.getLocation("https://test.test/api/location/1");
        mockServer.verify();
        Assertions.assertTrue(locationRespService.isEmpty());
    }
}
