package elm.business.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import elm.business.domain.entity.Business;
import elm.business.mapper.BusinessMapper;
import elm.business.service.BusinessService;
import elm.common.constants.SystemConstants;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("businessService")
public class BusinessServiceImpl extends ServiceImpl<BusinessMapper, Business> implements BusinessService {

    @Override
    public List<Business> getAllBusiness(String sortWay) {
        LambdaQueryWrapper<Business> queryWrapper = new LambdaQueryWrapper<>();

        //sortWay为1按销量排序，为2则按评分排序
        if(sortWay.equals(SystemConstants.BUSINESS_SORT_BY_ORDER_NUM)){
            queryWrapper.orderByDesc(Business::getOrderNum);
        }else if(sortWay.equals(SystemConstants.BUSINESS_SORT_BY_STARS)){
            queryWrapper.orderByDesc(Business::getStars);
        }

        return list(queryWrapper);
    }
}
