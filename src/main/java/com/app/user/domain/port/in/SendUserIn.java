package com.app.user.domain.port.in;


import com.app.user.domain.model.User;

public interface SendUserIn {

    public User saveUser(User user);
}
