package elm.common.service;

import elm.common.domain.ResponseResult;
import elm.common.domain.entity.User;
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
     * @return
     */
    ResponseResult login(User user);
}
