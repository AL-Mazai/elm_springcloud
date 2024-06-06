package elm.back.service;

import elm.back.domain.entity.User;
import elm.back.domain.vo.UserInfoVo;
import elm.common.domain.ResponseResult;

import java.util.List;

/**
 * (User)表服务接口
 *
 * @author makejava
 * @since 2024-06-03 11:28:10
 */
public interface UserService {

    /**
     * 获取用户信息
     * @param userId
     * @return
     */
    UserInfoVo getUserInfo(Integer userId);

    /**
     * 用户登录
     * @param user
     * @return
     */
    UserInfoVo login(User user);

    /**
     * 获取所有用户
     * @return
     */
    List<UserInfoVo> getAllUser();

    /**
     * 获取黑名单用户列表
     * @return
     */
    List<UserInfoVo> getBlackList();

    /**
     * 将用户拉入黑名单
     * @param userId
     * @return
     */
    Boolean prohibitUser(Integer userId);

    /**
     * 将用户移出黑名单
     * @param userId
     * @return
     */
    Boolean restoreUser(Integer userId);

    /**
     * 按关键字分页查询用户
     * @param pageNum
     * @param pageSize
     * @param userName
     * @param delTag
     * @return
     */
    List<UserInfoVo> selectUserByPage(Integer pageNum, Integer pageSize, String userName, Integer delTag);

    /**
     * 查询的用户数量
     * @param userName
     * @param delTag
     * @return
     */
    int selectUserCount(String userName, Integer delTag);
}
