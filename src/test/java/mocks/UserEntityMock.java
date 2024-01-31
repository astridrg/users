package mocks;

import com.app.user.controller.model.response.PhoneResponse;
import com.app.user.repository.model.PhoneEntity;
import com.app.user.repository.model.UserEntity;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class UserEntityMock {


    public static UUID uuid = UUID.fromString("e9186a58-12e9-460e-9ff9-d000630926b4");

    public static UserEntity userEntity(){
        UserEntity userEntity = new UserEntity();
        userEntity.setId(uuid);
        userEntity.setName("test");
        userEntity.setEmail("test");
        userEntity.setPassword("test");
        userEntity.setPhone(entityList());
        userEntity.setCreated(Timestamp.valueOf("2018-09-01 09:01:15"));
        userEntity.setIsActive(Boolean.TRUE);
        userEntity.setLastLogin(Timestamp.valueOf("2018-09-01 09:01:15"));
        userEntity.setModified(Timestamp.valueOf("2018-09-01 09:01:15"));
        return userEntity;
    }

    public static UserEntity userEntityPhoneWhithoutUser(){
        UserEntity userEntity = new UserEntity();
        userEntity.setId(uuid);
        userEntity.setName("test");
        userEntity.setEmail("test");
        userEntity.setPassword("test");
        userEntity.setPhone(entityListWhithoutUser());
        userEntity.setCreated(Timestamp.valueOf("2018-09-01 09:01:15"));
        userEntity.setIsActive(Boolean.TRUE);
        userEntity.setLastLogin(Timestamp.valueOf("2018-09-01 09:01:15"));
        userEntity.setModified(Timestamp.valueOf("2018-09-01 09:01:15"));
        return userEntity;
    }

    public static PhoneEntity phone(){
        PhoneEntity phoneEntity = new PhoneEntity();
        phoneEntity.setCityCode(20);
        phoneEntity.setCountryCode(20);
        phoneEntity.setId(uuid);
        phoneEntity.setUsers(userEntity());
        phoneEntity.setNumber(12345678);
        return phoneEntity;
    }

    public static PhoneEntity phonewhithoutUser(){
        PhoneEntity phoneEntity = new PhoneEntity();
        phoneEntity.setCityCode(20);
        phoneEntity.setCountryCode(20);
        phoneEntity.setId(uuid);
        phoneEntity.setNumber(12345678);
        return phoneEntity;
    }

    public static List<PhoneEntity> entityList(){
        List<PhoneEntity> entityList = new ArrayList<>();
        entityList.add(phone());
        return entityList;
    }

    public static List<PhoneEntity> entityListWhithoutUser(){
        List<PhoneEntity> entityList = new ArrayList<>();
        entityList.add(phonewhithoutUser());
        return entityList;
    }
}
