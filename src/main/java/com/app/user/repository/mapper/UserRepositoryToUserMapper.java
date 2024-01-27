package com.app.user.repository.mapper;

import com.app.user.domain.model.Phone;
import com.app.user.domain.model.User;
import com.app.user.repository.model.PhoneRepository;
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
        user.setLast_login(userEntity.getLastLogin());
        return user;
    }

    public Phone phoneRepositoryToPhone(PhoneRepository phoneRepository){
        Phone phone = new Phone();
        phone.setCityCode(phoneRepository.getCityCode());
        phone.setCountryCode(phoneRepository.getCountryCode());
        phone.setNumber(phoneRepository.getNumber());
        phone.setId(phoneRepository.getId());
        return phone;
    }

    public List<Phone> phoneListRepositoryToPhoneList(List<PhoneRepository> phoneRepositoryList){
        List<Phone> phoneList = new ArrayList<>();
        for ( PhoneRepository phoneRepository : phoneRepositoryList) {
            phoneList.add(phoneRepositoryToPhone(phoneRepository));
        }
        return phoneList;
    }
}
