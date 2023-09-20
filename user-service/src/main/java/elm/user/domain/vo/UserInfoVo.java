package elm.user.domain.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInfoVo {
    /**
     * 用户编号
     */
    @TableId
    private String userid;

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

}
