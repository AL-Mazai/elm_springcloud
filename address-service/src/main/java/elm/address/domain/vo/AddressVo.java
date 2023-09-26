package elm.address.domain.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressVo {
    /**
     * 送货地址编号
     */
    @TableId(type = IdType.AUTO)
    private Integer daid;

    /**
     * 联系人姓名
     */
    private String contactname;

    /**
     * 联系人性别
     */
    private Integer contactsex;

    /**
     * 联系人电话
     */
    private String contacttel;

    /**
     * 送货地址
     */
    private String address;

}
