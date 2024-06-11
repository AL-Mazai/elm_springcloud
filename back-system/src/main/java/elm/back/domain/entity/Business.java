package elm.back.domain.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * (Business)实体类
 *
 * @author makejava
 * @since 2024-06-11 17:31:57
 */
@Data
public class Business implements Serializable {
    private static final long serialVersionUID = -14361642984597324L;
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
     * 点餐分类
     */
    private Integer businessTypeId;
    /**
     * 起送费
     */
    private Double starPrice;
    /**
     * 配送费
     */
    private Double deliveryPrice;
    /**
     * 备注
     */
    private String remarks;
    /**
     * 订单数量
     */
    private Integer orderNum;
    /**
     * 商家评价
     */
    private Double stars;

}

