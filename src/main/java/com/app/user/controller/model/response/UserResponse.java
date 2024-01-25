package com.app.user.controller.model.response;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public class UserResponse {

    private UUID id;

    private String name;

    private String email;

    private String password;

    private Date created;

    private Date modified;

    private Date last_login;

    private Boolean isActive;

    private List<PhoneResponse> phone;

    public UserResponse(UUID id, String name, String email, String password, Date created, Date modified, Date last_login, Boolean isActive, List<PhoneResponse> phone) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.created = created;
        this.modified = modified;
        this.last_login = last_login;
        this.isActive = isActive;
        this.phone = phone;
    }

    public UserResponse() {

    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }

    public Date getLast_login() {
        return last_login;
    }

    public void setLast_login(Date last_login) {
        this.last_login = last_login;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public List<PhoneResponse> getPhone() {
        return phone;
    }

    public void setPhone(List<PhoneResponse> phone) {
        this.phone = phone;
    }
}
