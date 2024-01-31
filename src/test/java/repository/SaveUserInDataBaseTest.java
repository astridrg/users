package repository;

import com.app.user.domain.model.User;
import com.app.user.repository.SaveUserInDataBase;
import com.app.user.repository.jpa.CreateUserRepository;
import com.app.user.repository.mapper.UserRepositoryToUserMapper;
import com.app.user.repository.mapper.UserToUserRepositoryMapper;
import com.app.user.repository.model.UserEntity;
import mocks.UserEntityMock;
import mocks.UsersMock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class SaveUserInDataBaseTest {

    @Mock
    private CreateUserRepository createUserRepository;
    @Mock
    private UserToUserRepositoryMapper modelToRepository;
    @Mock
    private UserRepositoryToUserMapper userRepositoryToUserMapper;

    private SaveUserInDataBase saveUserInDataBase;

    @BeforeEach
    public void init(){
        saveUserInDataBase = new SaveUserInDataBase(createUserRepository, modelToRepository, userRepositoryToUserMapper );
    }

    @Test
    public void saveUserInDataBaseTest(){
        User userMock = UsersMock.user();
        UserEntity userEntity = UserEntityMock.userEntityPhoneWhithoutUser();

        Mockito.when(modelToRepository.userToUserRepository(userMock)).thenReturn(userEntity);
        Mockito.when(createUserRepository.save(userEntity)).thenReturn(userEntity);
        Mockito.when(userRepositoryToUserMapper.userRepositoryToUser(userEntity)).thenReturn(userMock);

        User user = saveUserInDataBase.saveUser(userMock);

        Assertions.assertEquals(userMock.getEmail(), user.getEmail());






    }
}
