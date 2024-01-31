package controller.mapper;

import com.app.user.controller.mapper.UserToUserResponseMapper;
import com.app.user.controller.model.response.UserResponse;
import mocks.UserResponseMock;
import mocks.UsersMock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class UserToUserResponseMock {

    private UserToUserResponseMapper userToUserResponseMapper;

    @BeforeEach
    public void init(){
        userToUserResponseMapper=new UserToUserResponseMapper();
    }

    @Test
    public void changeUserToUSerRequest(){
        UserResponse userResponse = userToUserResponseMapper.userToUserResponse(UsersMock.user());
        Assertions.assertEquals(UserResponseMock.userResponse().getEmail(), userResponse.getEmail());
        assertThat(userResponse).usingRecursiveComparison().isEqualTo(UserResponseMock.userResponse());

    }
}
