package com.app.user.domain.port.out;

import com.app.user.controller.model.request.UserRequest;
import com.app.user.domain.model.User;

public interface SendUserOut {

    public User sendUser(User user) ;
}
