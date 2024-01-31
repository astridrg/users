package com.app.user.repository.model;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name="phone")
public class PhoneEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private UUID id;

    @Column(name = "number")
    private Integer number;

    @Column(name = "city_code")
    private Integer cityCode;

    @Column(name = "country_code")
    private Integer countryCode;

    @ManyToOne
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumn(name = "userId", referencedColumnName = "id")
    private UserEntity user;

    public PhoneEntity(UUID id, Integer number, Integer cityCode, Integer countryCode, UserEntity user) {
        this.id = id;
        this.number = number;
        this.cityCode = cityCode;
        this.countryCode = countryCode;
        this.user = user;
    }

    public PhoneEntity() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getCityCode() {
        return cityCode;
    }

    public void setCityCode(Integer cityCode) {
        this.cityCode = cityCode;
    }

    public Integer getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(Integer countryCode) {
        this.countryCode = countryCode;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }
}
