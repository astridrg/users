package com.app.user.repository.mapper;

import com.app.user.domain.model.Phone;
import com.app.user.domain.model.User;
import com.app.user.repository.model.PhoneEntity;
import com.app.user.repository.model.UserEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserToUserRepositoryMapper {

    public UserEntity userToUserRepository(User user){
        UserEntity userEntity = new UserEntity();
        userEntity.setName(user.getName());
        userEntity.setEmail(user.getEmail());
        userEntity.setIsActive(Boolean.TRUE);
        userEntity.setPassword(user.getPassword());
        userEntity.setCreated(user.getCreated());
        userEntity.setModified(user.getModified());
        userEntity.setId(user.getId());
        userEntity.setLastLogin(user.getLastLogin());
        userEntity.setPhone(listModelToRepository(user.getPhone(), userEntity));
        return userEntity;
    }

    public PhoneEntity phoneModelToPhoneRepository(Phone phone, UserEntity userEntity){
    PhoneEntity phoneEntity = new PhoneEntity();
    phoneEntity.setCityCode(phone.getCityCode());
    phoneEntity.setCountryCode(phone.getCountryCode());
    phoneEntity.setNumber(phone.getNumber());
    phoneEntity.setId(phone.getId());
    phoneEntity.setUser(userEntity);
    return phoneEntity;
    }

    public List<PhoneEntity> listModelToRepository(List<Phone> phoneList, UserEntity userEntity){
        List<PhoneEntity> repositoryList = new ArrayList<>();
        for ( Phone phone : phoneList) {
            repositoryList.add(phoneModelToPhoneRepository(phone, userEntity));
        }
        return repositoryList;
    }

}
