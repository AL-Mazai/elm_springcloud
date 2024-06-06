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
import java.util.ArrayList;
import java.util.List;

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
        //登录验证
        if (dbUser != null && passwordEncoder.matches(user.getPassword(), dbUser.getPassword())) {
            UserInfoVo userInfoVo = BeanCopyUtils.copyBean(dbUser, UserInfoVo.class);
            return userInfoVo;
        }
        return null;
    }

    @Override
    public List<UserInfoVo> getAllUser() {
        List<User> userList = userMapper.getAllUser();
        List<UserInfoVo> userInfoVoList = BeanCopyUtils.copyBeanList(userList, UserInfoVo.class);
        return userInfoVoList;
    }

    @Override
    public List<UserInfoVo> getBlackList() {
        List<User> userList = userMapper.getBlackList();
        //只需展示部分信息
        List<UserInfoVo> blackUserList = BeanCopyUtils.copyBeanList(userList, UserInfoVo.class);
        return blackUserList;
    }

    @Override
    public Boolean prohibitUser(Integer userId) {
        Boolean isSuccess = userMapper.prohibitUser(userId);
        return isSuccess;
    }

    @Override
    public Boolean restoreUser(Integer userId) {
        Boolean isSuccess = userMapper.restoreUser(userId);
        return isSuccess;
    }

    @Override
    public List<UserInfoVo> selectUserByPage(Integer pageNum, Integer pageSize, String userName, Integer delTag) {
        List<User> userList = userMapper.selectUserByPage(pageNum, pageSize, userName, delTag);
        //将user转为userInfoVo
        List<UserInfoVo> userInfoVoList = BeanCopyUtils.copyBeanList(userList, UserInfoVo.class);
        return userInfoVoList;
    }

    @Override
    public int selectUserCount(String userName, Integer delTag) {
        return userMapper.selectUserCount(userName, delTag);
    }
}
