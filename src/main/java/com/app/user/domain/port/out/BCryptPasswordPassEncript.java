package com.app.user.domain.port.out;

import org.springframework.security.crypto.password.PasswordEncoder;

public interface BCryptPasswordPassEncript {
    public String encoder(String pass);
}
