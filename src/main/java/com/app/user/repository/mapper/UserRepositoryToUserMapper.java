package com.app.user.repository.mapper;

import com.app.user.domain.model.Phone;
import com.app.user.domain.model.User;
import com.app.user.repository.model.PhoneRepository;
import com.app.user.repository.model.UserRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserRepositoryToUserMapper {

    public User userRepositoryToUser(UserRepository userRepository){
        User user = new User();
        user.setName(userRepository.getName());
        user.setEmail(userRepository.getEmail());
        user.setPhone(phoneListRepositoryToPhoneList(userRepository.getPhone()));
        user.setPassword(userRepository.getPassword());
        user.setPassword(userRepository.getPassword());
        user.setIsactive(Boolean.TRUE);
        user.setId(userRepository.getId());
        user.setModified(userRepository.getModified());
        user.setCreated(userRepository.getCreated());
        user.setLast_login(userRepository.getLast_login());
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
