package com.app.user.repository;

import com.app.user.domain.model.User;
import com.app.user.domain.port.out.SendUserOut;
import com.app.user.repository.jpa.CreateUserRepository;
import com.app.user.repository.mapper.UserRepositoryToUserMapper;
import com.app.user.repository.mapper.UserToUserRepositoryMapper;
import com.app.user.repository.model.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

    public User sendUser(User user) {
        UserRepository userRepository = modelToRepository.userToUserRepository(user);
        UserRepository userRepositoryInDB = createUserRepository.save(userRepository);
        return userRepositoryToUserMapper.userRepositoryToUser(userRepositoryInDB);
    }
}

