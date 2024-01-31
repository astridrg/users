package com.app.user.controller.mapper;

import com.app.user.controller.model.request.PhoneRequest;
import com.app.user.controller.model.request.UserRequest;
import com.app.user.domain.model.Phone;
import com.app.user.domain.model.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserToUserRequestMapper {


    public User userToUserRequest(UserRequest userRequest){
        User user = new User();
        user.setName(userRequest.getName());
        user.setEmail(userRequest.getEmail());
        user.setPassword(userRequest.getPassword());
        user.setPhone(lisPhoneToPhoneRequest(userRequest.getPhone()));
        return user;
    }

    public Phone phoneToPhoneRequest(PhoneRequest phoneRequest){
        Phone phone = new com.app.user.domain.model.Phone();
        phone.setCountryCode(phoneRequest.getCountryCode());
        phone.setCityCode(phoneRequest.getCityCode());
        phone.setNumber(phoneRequest.getNumber());
        return phone;
    }

    public List<com.app.user.domain.model.Phone> lisPhoneToPhoneRequest(List<PhoneRequest> phoneRequestList){
        List<com.app.user.domain.model.Phone> responseList = new ArrayList<>();
        for ( PhoneRequest phoneRequest : phoneRequestList) {
            responseList.add(phoneToPhoneRequest(phoneRequest));
        }
        return responseList;
    }
}
