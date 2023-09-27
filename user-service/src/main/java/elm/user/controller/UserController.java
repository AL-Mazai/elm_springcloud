package elm.user.controller;

import elm.common.domain.ResponseResult;
import elm.user.domain.entity.User;
import elm.user.service.OSSUploadService;
import elm.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private OSSUploadService uploadService;

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

    @PostMapping("/register")
    public ResponseResult register(@RequestBody User user){
        return userService.register(user);
    }

    @PutMapping("/updateUserInfo")
    public ResponseResult editUserInfo(@RequestBody User user){
        return userService.eidtUserInfo(user);
    }

    /***
     * 头像上传
     * @param file
     * @return
     * @throws IOException
     */
    @PostMapping("/upload")
    public ResponseResult uploadImg(MultipartFile file) throws IOException {
        return uploadService.uploadImg(file);
    }
}
