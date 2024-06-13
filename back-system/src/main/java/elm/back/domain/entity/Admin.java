package elm.back.domain.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * (Admin)实体类
 *
 * @author makejava
 * @since 2024-06-13 15:31:12
 */
@Data
public class Admin implements Serializable {
    private static final long serialVersionUID = -24265181459435394L;
    /**
     * 用户编号
     */
    private Integer userid;
    /**
     * 密码
     */
    private String password;
    /**
     * 管理员名称
     */
    private String username;
    /**
     * 管理员性别（1：男； 0：女）
     */
    private Integer usersex;
    /**
     * 管理员头像
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

