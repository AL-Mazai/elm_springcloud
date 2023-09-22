package elm.user.service;

import elm.common.domain.ResponseResult;
import elm.user.domain.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author 1
* @description 针对表【user】的数据库操作Service
* @createDate 2023-09-12 18:32:03
*/
public interface UserService extends IService<User> {

    /**
     * 用户登录
     * @param user
     */
    ResponseResult login(User user);

    /**
     * 获取当前登录用户的信息
     */
    ResponseResult getUserInfo();

    /**
     * 退出登录
     * @return
     */
    ResponseResult logout();

}
