package elm.back.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FoodVo {
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
}
