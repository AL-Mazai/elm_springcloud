package elm.common.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import elm.common.domain.ResponseResult;
import elm.common.domain.entity.User;
import elm.common.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("{id}")
    public User queryById(@PathVariable("id") String id){
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getUserid, id);
        return userService.getOne(queryWrapper);
    }

    @PostMapping("/login")
    public ResponseResult login(@RequestBody User user){
        return userService.login(user);
    }

}
