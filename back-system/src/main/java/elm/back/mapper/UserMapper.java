package elm.back.mapper;

import elm.back.domain.entity.User;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * (User)表数据库访问层
 *
 * @author makejava
 * @since 2024-06-03 11:28:05
 */
public interface UserMapper{

    @Select("select * from user where userId = #{userId}")
    User getUserInfoById(Integer userId);

    @Select("SELECT * FROM user WHERE username = #{username}")
    User selectByUserName(String username);

    @Select("select * from user where delTag = 1")
    List<User> getAllUser();

    @Select("select * from user where delTag = 0")
    List<User> getBlackList();

    @Update("update user set delTag = 0 where userId = #{userId}")
    Boolean prohibitUser(Integer userId);

    @Update("update user set delTag = 1 where userId = #{userId}")
    Boolean restoreUser(Integer userId);

    List<User> selectUserByPage(Integer pageNum, Integer pageSize, String userName, Integer delTag);

    int selectUserCount(String userName, Integer delTag);
}

