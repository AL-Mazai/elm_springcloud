package elm.back.service.impl;

import elm.back.domain.entity.Admin;
import elm.back.domain.entity.User;
import elm.back.domain.vo.AdminVo;
import elm.back.domain.vo.AdminVo;
import elm.back.mapper.AdminMapper;
import elm.back.service.AdminService;
import elm.common.utils.BeanCopyUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * (Admin)表服务实现类
 *
 * @author makejava
 * @since 2024-06-13 15:31:13
 */
@Service("adminService")
public class AdminServiceImpl implements AdminService {
    @Resource
    private AdminMapper adminMapper;
    @Resource
    private PasswordEncoder passwordEncoder;

    @Override
    public AdminVo getUserInfo(Integer userId) {
        Admin user = adminMapper.getUserInfoById(userId);
        return BeanCopyUtils.copyBean(user, AdminVo.class);
    }

    @Override
    public AdminVo login(User user) {
        Admin dbUser = adminMapper.selectByUserName(user.getUsername());
        //登录验证
        if (dbUser != null && passwordEncoder.matches(user.getPassword(), dbUser.getPassword())) {
            AdminVo AdminVo = BeanCopyUtils.copyBean(dbUser, AdminVo.class);
            return AdminVo;
        }
        return null;
    }

}
