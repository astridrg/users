package com.app.user.repository.mapper;

import com.app.user.domain.model.Phone;
import com.app.user.domain.model.User;
import com.app.user.repository.model.PhoneEntity;
import com.app.user.repository.model.UserEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserRepositoryToUserMapper {

    public User userRepositoryToUser(UserEntity userEntity){
        User user = new User();
        user.setName(userEntity.getName());
        user.setEmail(userEntity.getEmail());
        user.setPhone(phoneListRepositoryToPhoneList(userEntity.getPhone()));
        user.setPassword(userEntity.getPassword());
        user.setPassword(userEntity.getPassword());
        user.setIsactive(Boolean.TRUE);
        user.setId(userEntity.getId());
        user.setModified(userEntity.getModified());
        user.setCreated(userEntity.getCreated());
        user.setLastLogin(userEntity.getLastLogin());
        return user;
    }

    public Phone phoneRepositoryToPhone(PhoneEntity phoneEntity){
        Phone phone = new Phone();
        phone.setCityCode(phoneEntity.getCityCode());
        phone.setCountryCode(phoneEntity.getCountryCode());
        phone.setNumber(phoneEntity.getNumber());
        phone.setId(phoneEntity.getId());
        return phone;
    }

    public List<Phone> phoneListRepositoryToPhoneList(List<PhoneEntity> phoneEntityList){
        List<Phone> phoneList = new ArrayList<>();
        for ( PhoneEntity phoneEntity : phoneEntityList) {
            phoneList.add(phoneRepositoryToPhone(phoneEntity));
        }
        return phoneList;
    }
}
