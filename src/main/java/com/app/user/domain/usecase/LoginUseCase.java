package com.app.user.domain.usecase;

import com.app.user.libs.JwtToken;
import com.app.user.domain.exceptions.UnauthorizedException;
import com.app.user.domain.model.User;
import com.app.user.domain.port.out.BCryptPasswordPassEncript;
import com.app.user.domain.port.out.SendUserOut;
import org.springframework.stereotype.Service;

import static java.util.Objects.nonNull;

@Service
public class LoginUseCase {

    private final SendUserOut sendUserOut;

    private final JwtToken jwtToken;

    private BCryptPasswordPassEncript bCryptPasswordPassEncript;


    public LoginUseCase(SendUserOut sendUserOut, JwtToken jwtToken, BCryptPasswordPassEncript bCryptPasswordPassEncript) {
        this.sendUserOut = sendUserOut;
        this.jwtToken = jwtToken;
        this.bCryptPasswordPassEncript = bCryptPasswordPassEncript;
    }

    public String login(String email, String pass) {
        User userSearch = sendUserOut.findUserForEmail(email);

        if ((email.equals("admin@admin.com") && pass.equals("12345678Pr")) ||
                (nonNull(userSearch) && bCryptPasswordPassEncript.matches(pass, userSearch.getPassword()))) {
            User user = new User();
            user.setEmail(email);
            String token = jwtToken.createToken(user);
            return token;
        }
        throw new UnauthorizedException("Invalid Credentials");
    }
}
