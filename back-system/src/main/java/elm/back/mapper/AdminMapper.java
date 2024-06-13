package elm.back.mapper;

import elm.back.domain.entity.Admin;
import elm.back.domain.entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * (Admin)表数据库访问层
 *
 * @author makejava
 * @since 2024-06-13 15:31:08
 */
public interface AdminMapper {

    @Select("select * from admin where userId = #{userId}")
    Admin getUserInfoById(Integer userId);

    @Select("SELECT * FROM admin WHERE username = #{username}")
    Admin selectByUserName(String username);
}

