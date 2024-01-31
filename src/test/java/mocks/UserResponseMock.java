package mocks;

import com.app.user.controller.model.response.PhoneResponse;
import com.app.user.controller.model.response.UserResponse;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class UserResponseMock {

    public static UUID uuid = UUID.fromString("e9186a58-12e9-460e-9ff9-d000630926b4");


    public static UserResponse userResponse(){
        UserResponse userResponse = new UserResponse();
        userResponse.setId(uuid);
        userResponse.setName("test");
        userResponse.setEmail("test");
        userResponse.setPassword("test");
        userResponse.setIsActive(Boolean.TRUE);
        userResponse.setCreated(Timestamp.valueOf("2018-09-01 09:01:15"));
        userResponse.setModified(Timestamp.valueOf("2018-09-01 09:01:15"));
        userResponse.setLast_login(Timestamp.valueOf("2018-09-01 09:01:15"));
        userResponse.setPhone(responseList());
        return userResponse;
    }

    public static PhoneResponse phoneResponse(){
        PhoneResponse phoneResponse = new PhoneResponse();
        phoneResponse.setCityCode(20);
        phoneResponse.setCountryCode(20);
        phoneResponse.setNumber(12345678);
        phoneResponse.setId(uuid);
        return phoneResponse;
    }

    public static List<PhoneResponse> responseList(){
        List<PhoneResponse> phoneResponseList = new ArrayList<>();
        phoneResponseList.add(phoneResponse());
        return phoneResponseList;
    }
}
