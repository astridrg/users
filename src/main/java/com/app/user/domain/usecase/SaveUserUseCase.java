package com.app.user.domain.usecase;

import com.app.user.domain.model.User;
import com.app.user.domain.port.in.SendUserIn;
import com.app.user.domain.port.out.SendUserOut;
import org.springframework.stereotype.Service;

@Service
public class SaveUserUseCase implements SendUserIn {

    private SendUserOut sendUserOut;

    public SaveUserUseCase(SendUserOut sendUserOut) {
        this.sendUserOut = sendUserOut;
    }

    public User saveUser(User user) {
        User userSave = sendUserOut.saveUser(user);
        return userSave;
    }
}
