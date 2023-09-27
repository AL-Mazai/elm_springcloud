package elm.business.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 商家类型(BusinessType)实体类
 *
 * @author makejava
 * @since 2023-09-27 15:54:35
 */
@TableName(value = "business_type")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BusinessType implements Serializable {
    private static final long serialVersionUID = 346438713733179868L;
    /**
     * 类型id
     */
    private Integer id;
    /**
     * 类型名称
     */
    private String typeName;
    /**
     * 类型logo
     */
    private String typeImg;
}

