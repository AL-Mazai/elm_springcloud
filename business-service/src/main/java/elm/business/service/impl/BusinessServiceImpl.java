package elm.business.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import elm.business.domain.entity.Business;
import elm.business.mapper.BusinessMapper;
import elm.business.service.BusinessService;
import elm.business.service.GetFoodService;
import elm.business.utils.RedisUtils;
import elm.common.constants.RedisConstants;
import elm.common.constants.SystemConstants;
import elm.common.domain.ResponseResult;
import elm.food.domain.entity.Food;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service("businessService")
public class BusinessServiceImpl extends ServiceImpl<BusinessMapper, Business> implements BusinessService {

    @Resource
    private GetFoodService getFoodService;
    @Resource
    private RedisUtils redisUtils;

    @Override
    public List<Business> getAllBusiness(String sortWay) {
        List<Business> businessList = new ArrayList<>();

        //sortWay为1按销量排序，为2则按评分排序
        if (sortWay.equals(SystemConstants.BUSINESS_SORT_BY_ORDER_NUM)) {
            businessList = redisUtils.getCacheList(RedisConstants.REDIS_BUSINESS_SORT_BY_ORDER_NUM_KEY);
        } else if (sortWay.equals(SystemConstants.BUSINESS_SORT_BY_STARS)) {
            businessList = redisUtils.getCacheList(RedisConstants.REDIS_BUSINESS_SORT_BY_STARS_KEY);
        }

        return businessList;
    }

    @Override
    public List<Business> listById(Integer typeId) {
        LambdaQueryWrapper<Business> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Business::getBusinessTypeId, typeId);

        List<Business> businessList = list(queryWrapper);
        // 遍历商家列表，调用 Food 服务获取食品信息，并加入商家信息中
        foodListOfBusiness(businessList);
        return businessList;
    }

    @Override
    public List<Business> listByName(String businessName) {
        LambdaQueryWrapper<Business> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.like(Business::getBusinessName, businessName);

        List<Business> businessList = list(queryWrapper);
        // 遍历商家列表，调用 Food 服务获取食品信息，并加入商家信息中
        foodListOfBusiness(businessList);
        return businessList;
    }

    /**
     * 将商家的食品加入商家信息当中
     * @param businessList
     */
    private void foodListOfBusiness(List<Business> businessList) {
        for (Business business : businessList) {
            ResponseResult foodListResult = getFoodService.getFoodOfBusiness(business.getBusinessId());
            business.setFoodList((List<Food>) foodListResult.getData());
        }
    }
}
