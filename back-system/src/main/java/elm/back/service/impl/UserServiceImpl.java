package elm.back.service.impl;

import elm.back.domain.entity.User;
import elm.back.domain.vo.UserInfoVo;
import elm.back.mapper.UserMapper;
import elm.back.service.UserService;
import elm.common.domain.ResponseResult;
import elm.common.utils.BeanCopyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import elm.common.utils.JwtUtil;
import org.springframework.security.crypto.password.PasswordEncoder;
import javax.annotation.Resource;
import java.beans.Encoder;

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
    @Resource
    private PasswordEncoder passwordEncoder;

    @Override
    public UserInfoVo getUserInfo(Integer userId) {
        User user = userMapper.getUserInfoById(userId);
        return BeanCopyUtils.copyBean(user, UserInfoVo.class);
    }

    @Override
    public UserInfoVo login(User user) {
        User dbUser = userMapper.selectByUserName(user.getUsername());
        if (dbUser != null && passwordEncoder.matches(user.getPassword(), dbUser.getPassword())) {
            UserInfoVo userInfoVo = BeanCopyUtils.copyBean(dbUser, UserInfoVo.class);
            return userInfoVo;
        }
        return null;
    }
}
