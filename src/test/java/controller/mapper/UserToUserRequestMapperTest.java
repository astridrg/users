package controller.mapper;

import com.app.user.controller.mapper.UserToUserRequestMapper;
import com.app.user.domain.model.User;
import mocks.UserRequestMock;
import mocks.UsersMock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class UserToUserRequestMapperTest {

    private UserToUserRequestMapper userToUserRequestMapper;

    @BeforeEach
    public void init(){
        userToUserRequestMapper=new UserToUserRequestMapper();
    }

    @Test
    public void changeUserToUSerRequest(){
        User user = userToUserRequestMapper.userToUserRequest(UserRequestMock.userRequest());
        Assertions.assertEquals(UsersMock.userWithoutTime().getEmail(), user.getEmail());
        assertThat(user).usingRecursiveComparison().isEqualTo(UsersMock.userWithoutTime());

    }

}
