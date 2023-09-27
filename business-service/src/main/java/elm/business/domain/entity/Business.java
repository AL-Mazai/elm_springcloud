package elm.business.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * (Business)实体类
 *
 * @author makejava
 * @since 2023-09-27 15:52:48
 */
@TableName(value = "business")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Business implements Serializable {
    private static final long serialVersionUID = 410733779442739185L;
    /**
     * 商家编号
     */
    private Integer businessid;
    /**
     * 商家名称
     */
    private String businessname;
    /**
     * 商家地址
     */
    private String businessaddress;
    /**
     * 商家介绍
     */
    private String businessexplain;
    /**
     * 商家图片（base64）
     */
    private String businessimg;
    /**
     * 分类ID
     */
    private Integer businessTypeId;
    /**
     * 起送费
     */
    private Double starprice;
    /**
     * 配送费
     */
    private Double deliveryprice;
    /**
     * 备注
     */
    private String remarks;
}

