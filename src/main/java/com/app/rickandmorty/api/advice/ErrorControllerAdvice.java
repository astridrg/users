package com.app.rickandmorty.api.advice;

import com.app.rickandmorty.domain.util.exception.ResourceNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Check known errors and return HTTP response as appropriate
 */
@RestControllerAdvice
@Slf4j
public class ErrorControllerAdvice {

    /**
     * handle ResourceNotFoundException response
     * @param e ResourceNotFoundException
     * @return HTTP Status 404 (Not Found)
     */
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity handlerResourceNotFoundException(ResourceNotFoundException e) {
        log.error(ResourceNotFoundException.class+" "+e.getMessage());
        return ResponseEntity.notFound().build();

    }

}
