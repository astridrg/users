package com.app.user.controller;


import com.app.user.controller.mapper.UserToUserRequestMapper;
import com.app.user.controller.mapper.UserToUserResponseMapper;
import com.app.user.controller.model.response.UserResponse;
import com.app.user.controller.model.request.UserRequest;
import com.app.user.domain.model.User;
import com.app.user.domain.port.in.SendUserIn;
import com.app.user.domain.port.out.BCryptPasswordPassEncript;
import com.app.user.domain.port.out.SendUserOut;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
public class SaveUserController {

    private SendUserIn sendUserIn;
    private UserToUserRequestMapper userToUserRequestMapper;
    private UserToUserResponseMapper userToUserResponseMapper;

    public SaveUserController(SendUserIn sendUserIn, UserToUserRequestMapper userToUserRequestMapper, UserToUserResponseMapper userToUserResponseMapper) {
        this.sendUserIn = sendUserIn;
        this.userToUserRequestMapper = userToUserRequestMapper;
        this.userToUserResponseMapper = userToUserResponseMapper;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserResponse> savedUser(@RequestBody @Valid UserRequest userRequest) {
        User user = userToUserRequestMapper.userToUserRequest(userRequest);
        UserResponse response = userToUserResponseMapper.userToUserResponse(sendUserIn.saveUser(user));
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}

