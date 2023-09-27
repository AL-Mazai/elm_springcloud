package elm.business.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import elm.business.service.BusinessTypeService;
import elm.business.mapper.BusinessTypeDao;
import elm.business.domain.entity.BusinessType;
import org.springframework.stereotype.Service;

/**
 * 商家类型(BusinessType)表服务实现类
 *
 * @author makejava
 * @since 2023-09-27 15:56:02
 */
@Service("businessTypeService")
public class BusinessTypeServiceImpl extends ServiceImpl<BusinessTypeDao, BusinessType> implements BusinessTypeService {

}

