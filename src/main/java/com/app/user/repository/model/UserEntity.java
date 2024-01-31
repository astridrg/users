package com.app.user.repository.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name="user")
public class UserEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private UUID id;

    @Column(name = "name")
    private String name;

    @Column(name = "email", unique=true)
    private String email;

    @Column(name = "password")
    private String password;

    @CreationTimestamp
    @Column(name = "created" , updatable = false)
    private Timestamp created;

    @UpdateTimestamp
    @Column(name = "modified")
    private Timestamp modified;

    @Column(name = "last_login")
    private Date lastLogin;

    @Column(name = "is_active")
    private Boolean isActive;


    @OneToMany(mappedBy = "user", cascade = CascadeType.PERSIST)
    private List <PhoneEntity> phone;

    public UserEntity(UUID id, String name, String email, String password, Timestamp created, Timestamp modified, Date lastLogin, Boolean isActive, List<PhoneEntity> phone) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.created = created;
        this.modified = modified;
        this.lastLogin = lastLogin;
        this.isActive = isActive;
        this.phone = phone;
    }

    public UserEntity() {
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

    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    public Timestamp getModified() {
        return modified;
    }

    public void setModified(Timestamp modified) {
        this.modified = modified;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public List<PhoneEntity> getPhone() {
        return phone;
    }

    public void setPhone(List<PhoneEntity> phone) {
        this.phone = phone;
    }
}
