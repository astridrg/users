package com.app.user.domain.port.out;

public interface BCryptPasswordPassEncript {
    public String encoder(String pass);
    public Boolean matches(String pass, String passDb);
}
