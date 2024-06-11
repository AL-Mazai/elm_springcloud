package elm.back.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BusinessVo {
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
     * 商家图片
     */
    private String businessImg;
    /**
     * 点餐分类
     */
    private Integer businessTypeId;
}
