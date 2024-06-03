package elm.user;


import elm.user.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class UserTest {

    @Resource
    private UserService userService;
    @Test
    public void userInfoTest(){
        System.out.println(userService.getById(6).toString());
    }
}
