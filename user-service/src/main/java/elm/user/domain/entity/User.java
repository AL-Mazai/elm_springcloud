package elm.user.domain.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @TableName user
 */
@TableName(value ="user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
    /**
     * 用户编号
     */
    @TableId
    private String userid;

    /**
     * 密码
     */
    private String password;

    /**
     * 用户名称
     */
    private String username;

    /**
     * 手机号码
     */
    private String phone;

    /**
     * 钱包
     */
    private Double money;

    /**
     * 用户性别（1：男； 0：女）
     */
    private Integer usersex;

    /**
     * 用户头像
     */
    private String userimg;

    /**
     * 删除标记（1：正常； 0：删除）
     */
    private Integer deltag;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

}