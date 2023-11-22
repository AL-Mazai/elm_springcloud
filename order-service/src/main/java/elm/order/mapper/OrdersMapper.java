package elm.order.mapper;

import elm.order.domain.entity.Orders;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
* @author 1
* @description 针对表【orders】的数据库操作Mapper
* @createDate 2023-11-22 14:15:41
* @Entity generator.domain.entity.Orders
*/
public interface OrdersMapper extends BaseMapper<Orders> {

    @Select("SELECT o.*, od.* FROM orders o LEFT JOIN order_detail od ON o.orderId = od.orderId")
    List<Orders> selectAllOrderWithDetails();
}




