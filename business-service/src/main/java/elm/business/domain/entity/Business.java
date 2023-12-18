package elm.business.domain.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import elm.food.domain.entity.Food;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * @TableName business
 */
@TableName(value = "business")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Business implements Serializable {
    /**
     * 商家编号
     */
    private Integer businessId;

    /**
     * 商家名称
     */
    private String businessName;

    /**
     * 商家地址
     */
    private String businessAddress;

    /**
     * 商家介绍
     */
    private String businessIntroduction;

    /**
     * 商家图片（base64）
     */
    private String businessImg;

    /**
     * 分类
     */
    private Integer businessTypeId;

    /**
     * 起送费
     */
    private BigDecimal starPrice;

    /**
     * 配送费
     */
    private BigDecimal deliveryPrice;

    /**
     * 备注
     */
    private String remarks;

    /**
     * 订单数量
     */
    private Integer orderNum;

    /**
     * 商家评价（以打星的方式呈现）
     */
    private Double stars;

    @TableField(exist = false)
    private List<Food> foodList;

    private static final long serialVersionUID = 1L;
}