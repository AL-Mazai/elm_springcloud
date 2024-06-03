package elm.back.service.impl;

import elm.back.domain.entity.User;
import elm.back.domain.vo.UserInfoVo;
import elm.back.mapper.UserMapper;
import elm.back.service.UserService;
import elm.common.utils.BeanCopyUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * (User)表服务实现类
 *
 * @author makejava
 * @since 2024-06-03 11:28:12
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public UserInfoVo getUserInfo(Integer userId) {
        User user = userMapper.getUserInfoById(userId);
        return BeanCopyUtils.copyBean(user, UserInfoVo.class);
    }
}
