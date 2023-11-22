package elm.order.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import elm.order.domain.entity.Orders;
import elm.order.service.OrdersService;
import elm.order.mapper.OrdersMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
* @author 1
* @description 针对表【orders】的数据库操作Service实现
* @createDate 2023-11-22 14:15:41
*/
@Service("ordersService")
public class OrdersServiceImpl extends ServiceImpl<OrdersMapper, Orders> implements OrdersService{

    @Resource
    private OrdersMapper ordersMapper;

    @Override
    public List<Orders> getAllOrder() {
        return ordersMapper.selectAllOrderWithDetails();
    }
}




