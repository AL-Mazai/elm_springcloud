package elm.food.controller;

import elm.common.domain.ResponseResult;
import elm.food.domain.entity.Food;
import elm.food.service.FoodService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Food)表控制层
 *
 * @author makejava
 * @since 2023-10-11 16:37:00
 */
@RestController
@RequestMapping("/food")
public class FoodController {
    /**
     * 服务对象
     */
    @Resource
    private FoodService foodService;

    @GetMapping("/foodList")
    public ResponseResult getFoodListByBusinessID(@RequestParam("businessId") Integer businessId){
        List<Food> foodList = foodService.getFoodListByBusinessID(businessId);
        return ResponseResult.okResult(foodList);
    }

    @GetMapping("/getFoodInfo")
    public ResponseResult getFoodInfo(@RequestParam("foodId") Integer foodId ){
        Food food = foodService.getById(foodId);
        return ResponseResult.okResult(food);
    }
}

