package elm.back.service;

import elm.back.domain.entity.Food;
import elm.back.domain.vo.FoodVo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * (Food)表服务接口
 *
 * @author makejava
 * @since 2024-06-13 16:49:07
 */
public interface FoodService {


    List<FoodVo> getAllFood();

    List<FoodVo> getDeletedFoodList();
}
