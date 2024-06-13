package elm.back.domain.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * (Food)实体类
 *
 * @author makejava
 * @since 2024-06-13 16:49:07
 */
@Data
public class Food implements Serializable {
    private static final long serialVersionUID = -48610335814895268L;
    /**
     * 食品编号
     */
    private Integer foodid;
    /**
     * 食品名称
     */
    private String foodname;
    /**
     * 食品介绍
     */
    private String foodexplain;
    /**
     * 食品图片
     */
    private String foodimg;
    /**
     * 食品价格
     */
    private Double foodprice;
    /**
     * 所属商家编号
     */
    private Integer businessid;
    /**
     * 备注
     */
    private String remarks;
    /**
     * 下单的食品数量
     */
    private Integer orderFoodNum;
    /**
     * 删除标记（1：正常； 0：删除）
     */
    private Integer deltag;

}

