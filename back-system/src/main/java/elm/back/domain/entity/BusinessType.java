package elm.back.domain.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * (BusinessType)实体类
 *
 * @author makejava
 * @since 2024-06-11 17:00:26
 */
@Data
public class BusinessType implements Serializable {
    private static final long serialVersionUID = 165829570457764510L;
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

    /**
     * 删除标记（1：正常； 0：删除）
     */
    private Integer deltag;

}

