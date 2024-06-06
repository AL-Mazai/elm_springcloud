package elm.back.controller;

import elm.back.domain.entity.User;
import elm.back.domain.vo.UserInfoVo;
import elm.back.service.UserService;
import elm.common.domain.ResponseResult;
import elm.common.enums.AppHttpCodeEnum;
import org.apache.ibatis.annotations.Update;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * (User)表控制层
 *
 * @author makejava
 * @since 2024-06-03 11:28:04
 */
@RestController
@RequestMapping("back_system_user")
public class UserController {
    /**
     * 服务对象
     */
    @Resource
    private UserService userService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseResult<User> queryById(@PathVariable("id") Integer id) {
        return ResponseResult.okResult(userService.getUserInfo(id));
    }

    @PostMapping("/login")
    public ResponseResult<User> login(@RequestBody User user){
        UserInfoVo loginUser = userService.login(user);
        System.out.println(loginUser);
        return ResponseResult.okResult(loginUser);
    }

    @GetMapping("/getAllUser")
    public ResponseResult<List<UserInfoVo>> getAllUser(){
        List<UserInfoVo> allUser = userService.getAllUser();
        return ResponseResult.okResult(allUser);
    }
    @GetMapping("/getBlackList")
    public ResponseResult<List<UserInfoVo>> getBlackList(){
        List<UserInfoVo> allUser = userService.getBlackList();
        return ResponseResult.okResult(allUser);
    }

    @DeleteMapping("/prohibitUser")
    public ResponseResult prohibitUser(@RequestParam("userId") Integer userId){
        Boolean isSuccess = userService.prohibitUser(userId);
        if (isSuccess) {
            return ResponseResult.okResult();
        }
        return ResponseResult.errorResult(AppHttpCodeEnum.SYSTEM_ERROR);
    }

    @PostMapping("/restoreUser")
    public ResponseResult restoreUser(@RequestBody Map<String, Integer> request){
        Integer userId = request.get("userId");
        Boolean isSuccess = userService.restoreUser(userId);
        if (isSuccess) {
            return ResponseResult.okResult();
        }
        return ResponseResult.errorResult(AppHttpCodeEnum.SYSTEM_ERROR);
    }

    @GetMapping("/selectUserByPage")
    public ResponseResult<Map<String, Object>> selectUserByPage(
            @RequestParam Integer pageNum,
            @RequestParam Integer pageSize,
            @RequestParam String userName,
            @RequestParam Integer delTag
    ) {
        pageNum = (pageNum - 1) * pageSize;
        List<UserInfoVo> userList = userService.selectUserByPage(pageNum, pageSize, userName, delTag);
        int total = userService.selectUserCount(userName, delTag);
        Map<String, Object> res = new HashMap<>();
        res.put("total", total);
        res.put("userList", userList);
        return ResponseResult.okResult(res);
    }

}

