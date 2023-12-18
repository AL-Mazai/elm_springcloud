package elm.business.service;


import elm.common.domain.ResponseResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("food-service")
public interface GetFoodService {

    @RequestMapping("/food/foodList")
    ResponseResult getFoodOfBusiness(@RequestParam("businessId") Integer businessId);
}
