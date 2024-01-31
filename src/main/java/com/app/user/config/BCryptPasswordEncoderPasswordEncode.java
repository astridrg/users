package com.app.user.config;

import com.app.user.domain.port.out.BCryptPasswordPassEncript;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class BCryptPasswordEncoderPasswordEncode implements BCryptPasswordPassEncript {

    private PasswordEncoder passwordEncoder;

    public BCryptPasswordEncoderPasswordEncode(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public String encoder(String pass) {
        return passwordEncoder.encode(pass);

    }
}
