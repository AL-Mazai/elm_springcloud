package elm.back.service.impl;

import elm.back.domain.entity.Business;
import elm.back.domain.entity.BusinessType;
import elm.back.domain.vo.BusinessVo;
import elm.back.mapper.BusinessTypeMapper;
import elm.back.service.BusinessTypeService;
import elm.common.utils.BeanCopyUtils;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.util.List;

/**
 * (BusinessType)表服务实现类
 *
 * @author makejava
 * @since 2024-06-11 17:00:29
 */
@Service("businessTypeService")
public class BusinessTypeServiceImpl implements BusinessTypeService {
    @Resource
    private BusinessTypeMapper businessTypeMapper;


    @Override
    public List<BusinessType> getAllBusinessType() {
        List<BusinessType> allBusinessType = businessTypeMapper.getAllBusinessType();
        return allBusinessType;
    }

    @Override
    public List<BusinessVo> getBusinessListByType(Integer typeId) {
        List<Business> businessListByType = businessTypeMapper.getBusinessListByType(typeId);
        List<BusinessVo> businessVoList = BeanCopyUtils.copyBeanList(businessListByType, BusinessVo.class);
        return businessVoList;
    }

    @Override
    public int updateBusinessInfo(Business business) {
        int isSuccess = businessTypeMapper.updateBusinessInfo(business);
        return isSuccess;
    }
}
