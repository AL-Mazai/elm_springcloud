package elm.user.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import elm.common.domain.ResponseResult;
import elm.user.domain.entity.LoginUser;
import elm.user.domain.entity.User;
import elm.user.service.UserService;
import elm.user.utils.RedisCache;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseResult login(@RequestBody User user){
        System.out.println(user);
        return userService.login(user);
    }

    @PostMapping("/logout")
    public ResponseResult logout(){
        return userService.logout();
    }

    @GetMapping("/getUserInfo")
    public ResponseResult getUserInfo(){
        return userService.getUserInfo();
    }

}
