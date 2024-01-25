package com.app.user.repository.mapper;

import com.app.user.domain.model.Phone;
import com.app.user.domain.model.User;
import com.app.user.repository.model.PhoneRepository;
import com.app.user.repository.model.UserRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserToUserRepositoryMapper {

    public UserRepository userToUserRepository(User user){
        UserRepository userRepository = new UserRepository();
        userRepository.setName(user.getName());
        userRepository.setEmail(user.getEmail());
        userRepository.setIsActive(Boolean.TRUE);
        userRepository.setPassword(user.getPassword());
        userRepository.setCreated(user.getCreated());
        userRepository.setModified(user.getModified());
        userRepository.setId(user.getId());
        userRepository.setLast_login(user.getLast_login());
        userRepository.setPhone(listModelToRepository(user.getPhone(), userRepository));
        return userRepository;
    }

    public PhoneRepository phoneModelToPhoneRepository(Phone phone, UserRepository userRepository){
    PhoneRepository phoneRepository = new PhoneRepository();
    phoneRepository.setCityCode(phone.getCityCode());
    phoneRepository.setCountryCode(phone.getCountryCode());
    phoneRepository.setNumber(phone.getNumber());
    phoneRepository.setId(phone.getId());
    phoneRepository.setUsers(userRepository);
    return phoneRepository;
    }

    public List<PhoneRepository> listModelToRepository(List<Phone> phoneList, UserRepository userRepository){
        List<PhoneRepository> repositoryList = new ArrayList<>();
        for ( Phone phone : phoneList) {
            repositoryList.add(phoneModelToPhoneRepository(phone, userRepository));
        }
        return repositoryList;
    }

}
