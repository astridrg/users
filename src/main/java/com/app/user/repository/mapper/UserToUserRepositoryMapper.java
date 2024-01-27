package com.app.user.repository.mapper;

import com.app.user.domain.model.Phone;
import com.app.user.domain.model.User;
import com.app.user.repository.model.PhoneRepository;
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
        userEntity.setLastLogin(user.getLast_login());
        userEntity.setPhone(listModelToRepository(user.getPhone(), userEntity));
        return userEntity;
    }

    public PhoneRepository phoneModelToPhoneRepository(Phone phone, UserEntity userEntity){
    PhoneRepository phoneRepository = new PhoneRepository();
    phoneRepository.setCityCode(phone.getCityCode());
    phoneRepository.setCountryCode(phone.getCountryCode());
    phoneRepository.setNumber(phone.getNumber());
    phoneRepository.setId(phone.getId());
    phoneRepository.setUsers(userEntity);
    return phoneRepository;
    }

    public List<PhoneRepository> listModelToRepository(List<Phone> phoneList, UserEntity userEntity){
        List<PhoneRepository> repositoryList = new ArrayList<>();
        for ( Phone phone : phoneList) {
            repositoryList.add(phoneModelToPhoneRepository(phone, userEntity));
        }
        return repositoryList;
    }

}
