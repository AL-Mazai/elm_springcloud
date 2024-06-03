package elm.back;

import elm.back.mapper.UserMapper;
import elm.back.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class UserTest {

    @Resource
    private UserMapper userMapper;

    @Test
    public void userInfoTest(){
        System.out.println(userMapper.getUserInfoById(6));
        System.out.println(userMapper.selectById(6));
    }
}
