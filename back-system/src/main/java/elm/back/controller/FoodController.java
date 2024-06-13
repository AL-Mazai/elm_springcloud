package elm.back.controller;

import elm.back.domain.entity.Food;
import elm.back.domain.vo.FoodVo;
import elm.back.service.FoodService;
import elm.common.domain.ResponseResult;
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
 * @since 2024-06-13 16:49:06
 */
@RestController
@RequestMapping("back_system_food")
public class FoodController {
    /**
     * 服务对象
     */
    @Resource
    private FoodService foodService;

    @GetMapping("getAllFood")
    public ResponseResult<List<FoodVo>> getAllFood(){
        List<FoodVo> allFood = foodService.getAllFood();
        return ResponseResult.okResult(allFood);
    }

    @GetMapping("/getDeletedFoodList")
    public ResponseResult<List<FoodVo>> getDeletedFoodList(){
        List<FoodVo> allDeletedFood = foodService.getDeletedFoodList();
        return ResponseResult.okResult(allDeletedFood);
    }


}

