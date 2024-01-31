package com.app.user.controller.mapper;

import com.app.user.controller.model.response.PhoneResponse;
import com.app.user.controller.model.response.UserResponse;
import com.app.user.domain.model.Phone;
import com.app.user.domain.model.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserToUserResponseMapper {

    public UserResponse userToUserResponse(User user){
        UserResponse userResponse = new UserResponse();
      userResponse.setName(user.getName());
      userResponse.setEmail(user.getEmail());
      userResponse.setPassword(user.getPassword());
      userResponse.setPhone(lisPhoneToPhoneResponse(user.getPhone()));
      userResponse.setId(user.getId());
      userResponse.setIsActive(Boolean.TRUE);
      userResponse.setLast_login(user.getLastLogin());
      userResponse.setCreated(user.getCreated());
      userResponse.setModified(user.getModified());
        return userResponse;
    }

    public PhoneResponse phoneToPhoneResponse(Phone phone){
        PhoneResponse phoneResponse = new PhoneResponse();
        phoneResponse.setCountryCode(phone.getCountryCode());
        phoneResponse.setCityCode(phone.getCityCode());
        phoneResponse.setNumber(phone.getNumber());
        phoneResponse.setId(phone.getId());
        return phoneResponse;
    }

    public List<PhoneResponse> lisPhoneToPhoneResponse(List<Phone> phoneList){
        List<PhoneResponse> responseList = new ArrayList<>();
        for ( Phone phone : phoneList) {
            responseList.add(phoneToPhoneResponse(phone));
        }
        return responseList;
    }
}
