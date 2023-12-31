package elm.address.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName delivery_address
 */
@TableName(value ="delivery_address")
@Data
public class DeliveryAddress implements Serializable {
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

    /**
     * 所属用户编号
     */
    private Integer userid;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

}