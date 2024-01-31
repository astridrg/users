package repository.mapper;

import com.app.user.domain.model.User;
import com.app.user.repository.mapper.UserRepositoryToUserMapper;
import com.app.user.repository.model.UserEntity;
import mocks.UserEntityMock;
import mocks.UsersMock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class UserRepositoryToUserMapperTest {

    private UserRepositoryToUserMapper userRepositoryToUserMapper;

    @BeforeEach
    public void init(){
        userRepositoryToUserMapper = new UserRepositoryToUserMapper();
    }

    @Test
    public void changeUserEntityToUser(){

        User userMock = UsersMock.user();
        UserEntity userEntity = UserEntityMock.userEntityPhoneWhithoutUser();

        User user = userRepositoryToUserMapper.userRepositoryToUser(userEntity);
        Assertions.assertEquals(userMock.getEmail(),user.getEmail());
        assertThat(user).usingRecursiveComparison().isEqualTo(userMock);

    }


}
