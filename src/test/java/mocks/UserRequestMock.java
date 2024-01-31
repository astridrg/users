package mocks;

import com.app.user.controller.model.request.PhoneRequest;
import com.app.user.controller.model.request.UserRequest;
import java.util.ArrayList;
import java.util.List;

public class UserRequestMock {

    public static UserRequest userRequest(){
        UserRequest userRequest = new UserRequest();
        userRequest.setEmail("test");
        userRequest.setName("test");
        userRequest.setPassword("test");
        userRequest.setPhone(phoneRequestList());
        return userRequest;
    }

    public static PhoneRequest phoneRequest(){
        PhoneRequest phoneRequest = new PhoneRequest();
        phoneRequest.setCityCode(20);
        phoneRequest.setCountryCode(20);
        phoneRequest.setNumber(12345678);
        return phoneRequest;
    }

    public static List<PhoneRequest> phoneRequestList(){
        List<PhoneRequest> phoneArrayList = new ArrayList<>();
        phoneArrayList.add(phoneRequest());
        return phoneArrayList;
    }
}
