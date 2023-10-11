package elm.food.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import elm.food.domain.entity.Food;
import elm.food.mapper.FoodMapper;
import elm.food.service.FoodService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Food)表服务实现类
 *
 * @author makejava
 * @since 2023-10-11 16:37:08
 */
@Service("foodService")
public class FoodServiceImpl extends ServiceImpl<FoodMapper, Food> implements FoodService {
    @Resource
    private FoodMapper foodMapper;

    @Override
    public List<Food> getFoodListByBusinessID(Integer businessId) {
        LambdaQueryWrapper<Food> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Food::getBusinessid, businessId);
        return list(queryWrapper);
    }
}
