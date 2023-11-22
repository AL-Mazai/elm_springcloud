package elm.order.domain.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 
 * @TableName orders
 */
@TableName(value = "orders")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Orders implements Serializable {
    /**
     * 订单编号
     */
    private Integer orderid;

    /**
     * 用户编号
     */
    private Integer userid;

    /**
     * 商家编号
     */
    private Integer businessid;

    /**
     * 订购日期
     */
    private Date orderdate;

    /**
     * 订单总价
     */
    private BigDecimal ordertotal;

    /**
     * 送货地址编号
     */
    private Integer daid;

    /**
     * 订单状态（0：未支付； 1：已支付）
     */
    private Integer orderstate;

    private static final long serialVersionUID = 1L;

    //订单与订单详情的一对多关系映射
    @TableField(exist = false)
    private List<OrderDetail> orderDetailList;
}