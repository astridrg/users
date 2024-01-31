package domain.usecase;

import com.app.user.domain.model.User;
import com.app.user.domain.port.out.BCryptPasswordPassEncript;
import com.app.user.domain.port.out.SendUserOut;
import com.app.user.domain.usecase.SaveUserUseCase;
import mocks.UsersMock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class SaveUserCaseTest {

    @Mock
    private SendUserOut sendUserOut;

    @Mock
    private BCryptPasswordPassEncript bCryptPasswordPassEncript;

    private SaveUserUseCase userUseCase;

    @BeforeEach
    public void init(){
        userUseCase = new SaveUserUseCase(sendUserOut, bCryptPasswordPassEncript);
    }

    @Test
    public void saveUserCaseTest(){
        User userMock = UsersMock.user();

        Mockito.when(bCryptPasswordPassEncript.encoder(userMock.getPassword())).thenReturn(userMock.getPassword());
        Mockito.when(sendUserOut.saveUser(userMock)).thenReturn(userMock);

        User user = userUseCase.saveUser(userMock);

        Assertions.assertEquals(user,userMock);




    }
}
