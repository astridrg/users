package com.app.user.controller.model.response;


import java.util.UUID;

public class PhoneResponse {

    private UUID id;

    private Integer number;

    private Integer cityCode;

    private Integer countryCode;

    public PhoneResponse(UUID id, Integer number, Integer cityCode, Integer countryCode) {
        this.id = id;
        this.number = number;
        this.cityCode = cityCode;
        this.countryCode = countryCode;
    }

    public PhoneResponse() {
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
}
