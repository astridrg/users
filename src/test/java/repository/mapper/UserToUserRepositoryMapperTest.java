package repository.mapper;

import com.app.user.domain.model.User;
import com.app.user.repository.mapper.UserToUserRepositoryMapper;
import com.app.user.repository.model.UserEntity;
import mocks.UserEntityMock;
import mocks.UsersMock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class UserToUserRepositoryMapperTest {

    private UserToUserRepositoryMapper userToUserRepositoryMapper;

    @BeforeEach
    public void init(){
        userToUserRepositoryMapper = new UserToUserRepositoryMapper();
    }


    @Test
    public void changeUserToUserEntity(){

        User userMock = UsersMock.user();
        UserEntity userEntity = UserEntityMock.userEntityPhoneWhithoutUser();

        UserEntity userRepository = userToUserRepositoryMapper.userToUserRepository(userMock);
        Assertions.assertEquals(userEntity.getEmail(),userRepository.getEmail());

    }
}
