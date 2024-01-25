package com.app.user.controller.model.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import java.util.List;


public class UserRequest {


    private String name;

    @Email(message = "invalid email")
    private String email;

    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>.]).{8,20}$", message = "Invalid password")
    private String password;

    private List<PhoneRequest> phoneRequest;

    public UserRequest(String name, String email, String password, List<PhoneRequest> phoneRequest) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.phoneRequest = phoneRequest;
    }

    public UserRequest() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<PhoneRequest> getPhone() {
        return phoneRequest;
    }

    public void setPhone(List<PhoneRequest> phoneRequest) {
        this.phoneRequest = phoneRequest;
    }
}
