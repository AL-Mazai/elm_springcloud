package elm.common.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import elm.common.domain.ResponseResult;
import elm.common.domain.entity.User;
import elm.common.service.UserService;
import elm.common.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
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
    private AuthenticationManager authenticationManager;

    @Override
    public ResponseResult login(User user) {
        // 创建一个包含用户名和密码的认证令牌
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword());
        // 使用认证管理器进行认证
        Authentication authenticate = authenticationManager.authenticate(authenticationToken);

        //判断是否认证通过
        if (Objects.isNull(authenticate)) {
            throw new RuntimeException("用户名或密码错误");
        }
        return null;
    }
}




