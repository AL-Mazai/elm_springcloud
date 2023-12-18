package elm.business.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import elm.business.domain.entity.Business;
import elm.business.mapper.BusinessMapper;
import elm.business.service.BusinessService;
import elm.business.service.GetFoodService;
import elm.common.constants.SystemConstants;
import elm.common.domain.ResponseResult;
import elm.food.domain.entity.Food;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("businessService")
public class BusinessServiceImpl extends ServiceImpl<BusinessMapper, Business> implements BusinessService {

    @Resource
    private GetFoodService getFoodService;

    @Override
    public List<Business> getAllBusiness(String sortWay) {
        LambdaQueryWrapper<Business> queryWrapper = new LambdaQueryWrapper<>();

        //sortWay为1按销量排序，为2则按评分排序
        if(sortWay.equals(SystemConstants.BUSINESS_SORT_BY_ORDER_NUM)){
            queryWrapper.orderByDesc(Business::getOrderNum);
        }else if(sortWay.equals(SystemConstants.BUSINESS_SORT_BY_STARS)){
            queryWrapper.orderByDesc(Business::getStars);
        }

        List<Business> businessList = list(queryWrapper);
        // 遍历商家列表，调用 Food 服务获取食品信息，并加入商家信息中
        for (Business business : businessList) {
            ResponseResult foodListResult = getFoodService.getFoodOfBusiness(business.getBusinessId());
            business.setFoodList( (List<Food>) foodListResult.getData());
        }

        return businessList;
    }

    @Override
    public List<Business> listById(Integer typeId) {
        LambdaQueryWrapper<Business> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Business::getBusinessTypeId, typeId);

        List<Business> businessList = list(queryWrapper);
        // 遍历商家列表，调用 Food 服务获取食品信息，并加入商家信息中
        for (Business business : businessList) {
            ResponseResult foodListResult = getFoodService.getFoodOfBusiness(business.getBusinessId());
            business.setFoodList( (List<Food>) foodListResult.getData());
        }
        return businessList;
    }
}
