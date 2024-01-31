package com.app.user.domain.port.out;

import com.app.user.domain.model.User;

public interface SendUserOut {

    public User saveUser(User user) ;

    public User findUserForEmail(String email) ;
}
