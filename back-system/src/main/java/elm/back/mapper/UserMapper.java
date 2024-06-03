package elm.back.mapper;

import elm.back.domain.entity.User;
import org.apache.ibatis.annotations.Select;

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
}

