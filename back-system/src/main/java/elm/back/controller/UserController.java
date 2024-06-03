package elm.back.controller;

import elm.back.domain.entity.User;
import elm.back.service.UserService;
import elm.common.domain.ResponseResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (User)表控制层
 *
 * @author makejava
 * @since 2024-06-03 11:28:04
 */
@RestController
@RequestMapping("back_system")
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
}

