package elm.back.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import elm.back.entity.User;
import elm.back.mapper.UserMapper;
import elm.back.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * (User)表服务实现类
 *
 * @author makejava
 * @since 2024-06-03 11:28:12
 */
@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
        implements UserService {

}
