package com.app.user.domain.usecase;

import com.app.user.domain.model.User;
import com.app.user.domain.port.in.SendUserIn;
import com.app.user.domain.port.out.BCryptPasswordPassEncript;
import com.app.user.domain.port.out.SendUserOut;
import org.springframework.stereotype.Service;

@Service
public class SaveUserUseCase implements SendUserIn {

    private SendUserOut sendUserOut;
    private BCryptPasswordPassEncript bCryptPasswordPassEncript;

    public SaveUserUseCase(SendUserOut sendUserOut, BCryptPasswordPassEncript bCryptPasswordPassEncript) {
        this.sendUserOut = sendUserOut;
        this.bCryptPasswordPassEncript = bCryptPasswordPassEncript;
    }

    public User saveUser(User user) {
        user.setPassword( bCryptPasswordPassEncript.encoder(user.getPassword()));
        User userSave = sendUserOut.saveUser(user);
        return userSave;
    }
}
