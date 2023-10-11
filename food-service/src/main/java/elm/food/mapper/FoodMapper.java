package elm.food.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import elm.food.domain.entity.Food;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * (Food)表数据库访问层
 *
 * @author makejava
 * @since 2023-10-11 16:37:01
 */
public interface FoodMapper extends BaseMapper<Food>{

}

