package elm.order.domain.entity;

import java.io.Serializable;

/**
 * (OrderDetail)实体类
 *
 * @author makejava
 * @since 2023-11-22 14:34:45
 */
public class OrderDetail implements Serializable {
    private static final long serialVersionUID = 917812494623007268L;
/**
     * 订单明细编号
     */
    private Integer odid;
/**
     * 所属订单编号
     */
    private Integer orderid;
/**
     * 食品编号
     */
    private Integer foodid;
/**
     * 数量
     */
    private Integer quantity;


    public Integer getOdid() {
        return odid;
    }

    public void setOdid(Integer odid) {
        this.odid = odid;
    }

    public Integer getOrderid() {
        return orderid;
    }

    public void setOrderid(Integer orderid) {
        this.orderid = orderid;
    }

    public Integer getFoodid() {
        return foodid;
    }

    public void setFoodid(Integer foodid) {
        this.foodid = foodid;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

}

