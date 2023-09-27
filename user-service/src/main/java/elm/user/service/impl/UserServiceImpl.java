package elm.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import elm.common.constants.RedisConstants;
import elm.common.domain.ResponseResult;
import elm.common.enums.AppHttpCodeEnum;
import elm.common.exception.SystemException;
import elm.common.utils.BeanCopyUtils;
import elm.user.utils.RedisCache;
import elm.user.domain.entity.LoginUser;
import elm.user.domain.entity.User;
import elm.user.domain.vo.LoginVo;
import elm.user.domain.vo.UserInfoVo;
import elm.user.service.UserService;
import elm.user.mapper.UserMapper;
import elm.common.utils.JwtUtil;
import elm.user.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
* @author zzw
* @description 针对表【user】的数据库操作Service实现
* @createDate 2023-09-12 18:32:03
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

    @Autowired
    private RedisCache redisCache;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public ResponseResult login(User user) {
        // 创建一个包含用户名和密码的认证令牌
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword());
        // 使用认证管理器进行认证
        Authentication authenticate = authenticationManager.authenticate(authenticationToken);

//        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++");
//        System.out.println(SecurityContextHolder.getContext().getAuthentication().getPrincipal());

        //判断是否认证通过
        if (Objects.isNull(authenticate)) {
            throw new RuntimeException("用户名或密码错误");
        }

        // 获取认证通过后的登录用户信息
        LoginUser loginUser = (LoginUser) authenticate.getPrincipal();

        // 使用用户的 ID 生成 JWT 令牌
        String userId = loginUser.getUser().getUserid().toString();
        String jwt = JwtUtil.createJWT(userId);

        //将用户信息存入redis
        redisCache.setCacheObject(RedisConstants.REDIS_LOGIN_KEY + userId, loginUser);

        //把token和user封装并返回
        UserInfoVo userVo = BeanCopyUtils.copyBean(loginUser.getUser(), UserInfoVo.class);
        LoginVo loginVo = new LoginVo(jwt, userVo);

        return ResponseResult.okResult(loginVo);
    }

    @Override
    public ResponseResult getUserInfo() {
        //获取当前用户id
        Integer userId = SecurityUtils.getUserId();
        //根据用户id查询用户信息
        User user = getById(userId);

        //将信息封装成Vo并返回
        UserInfoVo userInfoVo = BeanCopyUtils.copyBean(user, UserInfoVo.class);

        return ResponseResult.okResult(userInfoVo);
    }

    @Override
    public ResponseResult logout() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        LoginUser loginUser = (LoginUser)authentication.getPrincipal();
        //获取userid
        String userId = loginUser.getUser().getUserid().toString();
        //删除redis中的用户信息
        redisCache.deleteObject(RedisConstants.REDIS_LOGIN_KEY + userId);
        return ResponseResult.okResult();
    }

    @Override
    public ResponseResult register(User user) {
        //对数据进行是否存在的判断
        if (userNameExist(user.getUsername())) {
            throw new SystemException(AppHttpCodeEnum.USERNAME_EXIST);
//            return ResponseResult.errorResult(AppHttpCodeEnum.USERNAME_EXIST);
        }
        if (phoneExit(user.getPhone())) {
            throw new SystemException(AppHttpCodeEnum.PHONE_EXIST);
//            return ResponseResult.errorResult(AppHttpCodeEnum.PHONE_EXIST);
        }

        //对密码进行加密
        String passwordEncode = passwordEncoder.encode(user.getPassword());
        user.setPassword(passwordEncode);

        //存入数据库
        save(user);
        return ResponseResult.okResult(AppHttpCodeEnum.SUCCESS);
    }

    @Override
    public ResponseResult eidtUserInfo(User user) {
        updateById(user);
        return ResponseResult.okResult();
    }

    private boolean phoneExit(String phone) {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper();
        queryWrapper.eq(User::getPhone, phone);
        return count(queryWrapper) > 0;
    }

    private boolean userNameExist(String userName) {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper();
        queryWrapper.eq(User::getUsername, userName);
        return count(queryWrapper) > 0;
    }
}




