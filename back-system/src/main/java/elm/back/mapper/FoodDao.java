package elm.back.mapper;

import elm.back.domain.entity.Food;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * (Food)表数据库访问层
 *
 * @author makejava
 * @since 2024-06-13 16:49:06
 */
public interface FoodDao {


    @Select("select * from food where delTag = 1")
    List<Food> getAllFood();

    @Select("select * from food where delTag = 0")
    List<Food> getDeletedFoodList();
}

