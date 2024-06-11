package elm.back.service;

import elm.back.domain.entity.Business;
import elm.back.domain.entity.BusinessType;
import elm.back.domain.vo.BusinessVo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * (BusinessType)表服务接口
 *
 * @author makejava
 * @since 2024-06-11 17:00:29
 */
public interface BusinessTypeService {

    List<BusinessType> getAllBusinessType();

    List<BusinessVo> getBusinessListByType(Integer typeId);

}
