package elm.food.service;

import com.baomidou.mybatisplus.extension.service.IService;
import elm.food.domain.entity.Food;

import java.util.List;

/**
 * (Food)表服务接口
 *
 * @author makejava
 * @since 2023-10-11 16:37:06
 */
public interface FoodService extends IService<Food> {

    /**
     * 获取商家的所有食物
     * @param businessId
     * @return
     */
    List<Food> getFoodListByBusinessID(Integer businessId);
}
