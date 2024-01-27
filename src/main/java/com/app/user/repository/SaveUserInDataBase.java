package com.app.user.repository;

import com.app.user.domain.model.User;
import com.app.user.domain.port.out.SendUserOut;
import com.app.user.repository.jpa.CreateUserRepository;
import com.app.user.repository.mapper.UserRepositoryToUserMapper;
import com.app.user.repository.mapper.UserToUserRepositoryMapper;
import com.app.user.repository.model.UserEntity;
import org.springframework.stereotype.Service;

@Service
public class SaveUserInDataBase implements SendUserOut {

    private CreateUserRepository createUserRepository;
    private UserToUserRepositoryMapper modelToRepository;
    private UserRepositoryToUserMapper userRepositoryToUserMapper;

    public SaveUserInDataBase(CreateUserRepository createUserRepository, UserToUserRepositoryMapper modelToRepository, UserRepositoryToUserMapper userRepositoryToUserMapper) {
        this.createUserRepository = createUserRepository;
        this.modelToRepository = modelToRepository;
        this.userRepositoryToUserMapper = userRepositoryToUserMapper;
    }

    public User saveUser(User user) {
        UserEntity userEntity = modelToRepository.userToUserRepository(user);
        UserEntity userEntityInDB = createUserRepository.save(userEntity);
        return userRepositoryToUserMapper.userRepositoryToUser(userEntityInDB);
    }

    public User findUserForEmail(String email) {
        UserEntity userEntityInDB = createUserRepository.findByEmail(email);
        return userRepositoryToUserMapper.userRepositoryToUser(userEntityInDB);
    }
}

