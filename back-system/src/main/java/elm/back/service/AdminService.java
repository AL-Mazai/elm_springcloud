package elm.back.service;

import elm.back.domain.entity.Admin;
import elm.back.domain.entity.User;
import elm.back.domain.vo.AdminVo;
import elm.back.domain.vo.UserInfoVo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (Admin)表服务接口
 *
 * @author makejava
 * @since 2024-06-13 15:31:13
 */
public interface AdminService {
    /**
     * 获取用户信息
     * @param userId
     * @return
     */
    AdminVo getUserInfo(Integer userId);

    /**
     * 用户登录
     * @param user
     * @return
     */
    AdminVo login(User user);

}
