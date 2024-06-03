package elm.back.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import elm.back.entity.User;
import org.apache.ibatis.annotations.Select;

/**
 * (User)表数据库访问层
 *
 * @author makejava
 * @since 2024-06-03 11:28:05
 */
public interface UserMapper extends BaseMapper<User> {

    @Select("select * from user where userId = #{userId}")
    User getUserInfoById(Integer userId);
}

