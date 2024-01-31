package com.app.user.controller;

import com.app.user.config.JwtTokenUtil;
import com.app.user.controller.model.request.AuthRequest;
import com.app.user.domain.model.User;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "api/")
public class AuthApi {

    private final JwtTokenUtil jwtTokenUtil;

    public AuthApi(JwtTokenUtil jwtTokenUtil) {
        this.jwtTokenUtil = jwtTokenUtil;
    }

    @PostMapping("login")
    public ResponseEntity<String> login(@RequestBody @Valid AuthRequest request) {
        if (request.getEmail().equals("admin@admin.com") && request.getPassword().equals("12345678Pr")) {
            User user = new User();
            user.setEmail(request.getEmail());
            String token = jwtTokenUtil.createToken(user);
            return ResponseEntity.ok()
                    .header(
                            HttpHeaders.AUTHORIZATION,
                            token
                    )
                    .body(token);
        }
       return new ResponseEntity<String>("Invalid Credentials", HttpStatus.UNAUTHORIZED);
    }
}
