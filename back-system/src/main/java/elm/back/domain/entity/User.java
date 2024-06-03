package elm.back.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * (User)实体类
 *
 * @author makejava
 * @since 2024-06-03 11:28:07
 */
@TableName(value = "user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
    private static final long serialVersionUID = -53782033347257493L;
    /**
     * 用户编号
     */
    private Integer userid;
    /**
     * 密码
     */
    private String password;
    /**
     * 用户名称
     */
    private String username;
    /**
     * 用户性别（1：男； 0：女）
     */
    private Integer usersex;
    /**
     * 钱包
     */
    private Integer money;
    /**
     * 用户头像
     */
    private String userimg;
    /**
     * 手机号码
     */
    private String phone;
    /**
     * 删除标记（1：正常； 0：删除）
     */
    private Integer deltag;
}

