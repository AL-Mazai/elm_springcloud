package elm.back.service;

import elm.back.domain.entity.User;
import elm.back.domain.vo.UserInfoVo;

/**
 * (User)表服务接口
 *
 * @author makejava
 * @since 2024-06-03 11:28:10
 */
public interface UserService {

    UserInfoVo getUserInfo(Integer userId);

}
