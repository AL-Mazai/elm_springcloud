package elm.business;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import elm.business.domain.entity.Business;
import elm.business.service.BusinessService;
import elm.business.service.GetFoodService;
import elm.business.utils.RedisUtils;
import elm.common.constants.RedisConstants;
import elm.common.domain.ResponseResult;
import elm.food.domain.entity.Food;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import java.util.List;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@MapperScan("elm.business.mapper")
public class BusinessApplication {
    public static void main(String[] args) {
        SpringApplication.run(BusinessApplication.class, args);
    }

    @Resource
    private BusinessService businessService;
    @Resource
    private RedisUtils redisUtils;
    @Resource
    private GetFoodService getFoodService;

    /**
     * 项目启动时将商家数据加载到redis中
     * @PostConstruct注解会在项目启动的时候执行该方法，也可以理解为在spring容器初始化的时候执行该方法
     */
    @PostConstruct
    public void saveBusinessToRedis() {
        LambdaQueryWrapper<Business> queryWrapper = new LambdaQueryWrapper<>();

        //按销量排序存入redis
        queryWrapper.orderByDesc(Business::getOrderNum);
        List<Business> allBusinessSortBySale = businessService.list(queryWrapper);
        foodListOfBusiness(allBusinessSortBySale);
        redisUtils.setCacheList(RedisConstants.REDIS_BUSINESS_SORT_BY_ORDER_NUM_KEY, allBusinessSortBySale);

        queryWrapper.clear();
        //按评分排序存入redis
        queryWrapper.orderByDesc(Business::getStars);
        List<Business> allBusinessSortByScore = businessService.list(queryWrapper);
        foodListOfBusiness(allBusinessSortByScore);
        redisUtils.setCacheList(RedisConstants.REDIS_BUSINESS_SORT_BY_STARS_KEY, allBusinessSortByScore);
    }
    @PreDestroy
    public void clearBusinessOfRedis(){
        redisUtils.deleteObject(RedisConstants.REDIS_BUSINESS_SORT_BY_ORDER_NUM_KEY);
        redisUtils.deleteObject(RedisConstants.REDIS_BUSINESS_SORT_BY_STARS_KEY);
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
