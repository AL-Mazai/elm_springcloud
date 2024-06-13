package elm.back.service.impl;

import elm.back.domain.entity.Food;
import elm.back.domain.vo.FoodVo;
import elm.back.mapper.FoodDao;
import elm.back.service.FoodService;
import elm.common.utils.BeanCopyUtils;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Food)表服务实现类
 *
 * @author makejava
 * @since 2024-06-13 16:49:07
 */
@Service("foodService")
public class FoodServiceImpl implements FoodService {
    @Resource
    private FoodDao foodDao;

    @Override
    public List<FoodVo> getAllFood() {
        List<Food> foodList = foodDao.getAllFood();
        return BeanCopyUtils.copyBeanList(foodList, FoodVo.class);
    }

    @Override
    public List<FoodVo> getDeletedFoodList() {
        List<Food> deletedFoodList = foodDao.getDeletedFoodList();
        return BeanCopyUtils.copyBeanList(deletedFoodList, FoodVo.class);
    }
}
