package com.app.user.controller.handler;

import com.app.user.controller.model.response.ErrorMessage;
import com.app.user.domain.exceptions.UnauthorizedException;
import org.hibernate.JDBCException;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class MessagePasswordHandlerException {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorMessage> handlerMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        ErrorMessage errorMessage = new ErrorMessage(e.getMessage());
        return ResponseEntity.badRequest().body(errorMessage);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErrorMessage> handlerConstraintViolationException(ConstraintViolationException e) {
        ErrorMessage errorMessage = new ErrorMessage("El correo ya registrado");
        return ResponseEntity.badRequest().body(errorMessage);
    }

    @ExceptionHandler(UnauthorizedException.class)
    public ResponseEntity<ErrorMessage> handlerUnauthorizedException(UnauthorizedException e) {
        ErrorMessage errorMessage = new ErrorMessage(e.getMessage());
        return  new ResponseEntity<ErrorMessage>(errorMessage, HttpStatus.UNAUTHORIZED);
    }


}
