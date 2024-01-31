package controller;

import com.app.user.controller.SaveUserController;
import com.app.user.controller.mapper.UserToUserRequestMapper;
import com.app.user.controller.mapper.UserToUserResponseMapper;
import com.app.user.controller.model.request.UserRequest;
import com.app.user.controller.model.response.UserResponse;
import com.app.user.domain.model.User;
import com.app.user.domain.port.in.SendUserIn;
import mocks.UserRequestMock;
import mocks.UserResponseMock;
import mocks.UsersMock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

@ExtendWith(MockitoExtension.class)
public class SaveUserControllerTest {

    @Mock
    private SendUserIn sendUserIn;
    @Mock
    private UserToUserRequestMapper userToUserRequestMapper;
    @Mock
    private UserToUserResponseMapper userToUserResponseMapper;

    private SaveUserController saveUserController;

    @BeforeEach
    public void init(){
        saveUserController = new SaveUserController(sendUserIn, userToUserRequestMapper, userToUserResponseMapper );
    }

    @Test
    public void saveUserControllerTest(){
        UserRequest userRequestMock = UserRequestMock.userRequest();
        User userMock = UsersMock.user();
        UserResponse userResponse = UserResponseMock.userResponse();

        Mockito.when(userToUserRequestMapper.userToUserRequest(userRequestMock)).thenReturn(userMock);
        Mockito.when(sendUserIn.saveUser(userMock)).thenReturn(userMock);
        Mockito.when(userToUserResponseMapper.userToUserResponse(userMock)).thenReturn(userResponse);
        ResponseEntity<UserResponse> userResponseResponseEntity =
                saveUserController.savedUser(userRequestMock);

        Assertions.assertEquals(userResponse.getEmail(), userResponseResponseEntity.getBody().getEmail());

    }
}
