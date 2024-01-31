package com.app.user.controller;

import com.app.user.controller.model.request.AuthRequest;
import com.app.user.domain.usecase.LoginUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "api/")
public class LoginController {

    private LoginUseCase loginUseCase;

    public LoginController(LoginUseCase loginUseCase) {
        this.loginUseCase = loginUseCase;
    }

    @PostMapping("login")
    public ResponseEntity<String> login(@RequestBody @Valid AuthRequest request) {
       return new ResponseEntity<>(loginUseCase.login(request.getEmail(), request.getPassword()), HttpStatus.OK);
    }
}
