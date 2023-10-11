package elm.food.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * (Food)实体类
 *
 * @author makejava
 * @since 2023-10-11 16:37:04
 */
@TableName(value = "food")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Food implements Serializable {
    private static final long serialVersionUID = 866095111604756101L;
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
}

