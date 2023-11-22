package elm.order.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * (OrderDetail)实体类
 *
 * @author makejava
 * @since 2023-11-22 15:29:03
 */
@TableName(value = "order_detail")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetail implements Serializable {
    private static final long serialVersionUID = -95340378894037901L;
    /**
     * 订单明细编号
     */
    private Integer odid;
    /**
     * 食物名称
     */
    private String foodName;
    /**
     * 所属订单编号
     */
    private Integer orderid;
    /**
     * 食品编号
     */
    private Integer foodid;
    /**
     * 食物数量
     */
    private Integer quantity;
    /**
     * 食物logo
     */
    private String foodImg;
    /**
     * 食物价格
     */
    private Double foodPrice;
}

