package com.app.rickandmorty.domain.util.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResponseErrorHandler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.http.HttpResponse;
import java.util.stream.Collectors;

@Slf4j
@Component
public class RestTemplateResponseErrorHandler
        implements ResponseErrorHandler {

    @Override
    public boolean hasError(ClientHttpResponse httpResponse)
            throws IOException {

        return (
                httpResponse.getStatusCode().series() == HttpStatus.Series.CLIENT_ERROR
                        || httpResponse.getStatusCode().series() == HttpStatus.Series.SERVER_ERROR);
    }

    @Override
    public void handleError(ClientHttpResponse response) throws IOException {

    }

    @Override
    public void handleError(URI url, HttpMethod method, ClientHttpResponse httpResponse)
            throws IOException {

        if (httpResponse.getStatusCode()
                .series() == HttpStatus.Series.SERVER_ERROR || httpResponse.getStatusCode()
                .series() == HttpStatus.Series.CLIENT_ERROR) {

            this.pritnTraceError(url, method, httpResponse);

        }
    }

    private void pritnTraceError(URI url, HttpMethod method, ClientHttpResponse httpResponse) throws IOException {
        log.error("Error when querying "
                .concat(method.name())
                .concat(" ")
                .concat(url.getHost())
                .concat(url.getPath()));

        log.error("Response Status "
                .concat(httpResponse.getStatusCode().toString())
                .concat(" ")
                .concat(inputStreamToString(httpResponse.getBody())));
    }

    private String inputStreamToString(InputStream inputStream){
        return new BufferedReader(new InputStreamReader(inputStream))
                .lines().collect(Collectors.joining("\n"));
    }
}
