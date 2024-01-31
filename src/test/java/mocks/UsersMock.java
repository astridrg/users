package mocks;

import com.app.user.domain.model.Phone;
import com.app.user.domain.model.User;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class UsersMock {

    public static UUID uuid = UUID.fromString("e9186a58-12e9-460e-9ff9-d000630926b4");

    public static User user(){
        User user = new User();
        user.setId(uuid);
        user.setName("test");
        user.setEmail("test");
        user.setPassword("test");
        user.setPhone(phoneList());
        user.setLastLogin(Timestamp.valueOf("2018-09-01 09:01:15"));
        user.setModified(Timestamp.valueOf("2018-09-01 09:01:15"));
        user.setCreated(Timestamp.valueOf("2018-09-01 09:01:15"));
        user.setIsactive(Boolean.TRUE);
        return user;
    }

    public static User userWithoutTime(){
        User user = new User();
        user.setName("test");
        user.setEmail("test");
        user.setPassword("test");
        user.setPhone(phoneListMock());;
        return user;
    }

    public static Phone phone(){
        Phone phone = new Phone();
        phone.setId(uuid);
        phone.setCityCode(20);
        phone.setNumber(12345678);
        phone.setCountryCode(20);
        return phone;
    }

    public static Phone phoneWhithoutUi(){
        Phone phone = new Phone();
        phone.setCityCode(20);
        phone.setNumber(12345678);
        phone.setCountryCode(20);
        return phone;
    }

    public static List<Phone> phoneList(){
        List<Phone> phoneArrayList = new ArrayList<>();
        phoneArrayList.add(phone());
        return phoneArrayList;
    }

    public static List<Phone> phoneListMock(){
        List<Phone> phoneArrayList = new ArrayList<>();
        phoneArrayList.add(phoneWhithoutUi());
        return phoneArrayList;
    }

}
