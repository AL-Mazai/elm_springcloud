package elm.order.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import elm.order.domain.entity.OrderDetail;
import elm.order.domain.entity.Orders;
import elm.order.mapper.OrderDetailMapper;
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
        List<Orders> ordersList = ordersMapper.selectAllOrderWithDetails();
        //通过订单详情id来判断订单中的订单详情列表是否为空
        for (Orders order : ordersList) {
//            // 查询并设置businessName
//            String businessName = ordersMapper.selectById(order.getOrderid()).getBusinessName();
//            order.setBusinessName(businessName);
//
//            // 查询并设置orderDetailList中每个OrderDetail的foodName和foodPrice
//            for (OrderDetail orderDetail : order.getOrderDetailList()) {
//                String foodName = orderDetailMapper.selectById(orderDetail.getOdid()).getFoodName();
//                Double foodPrice = orderDetailMapper.selectById(orderDetail.getOdid()).getFoodPrice();
//                orderDetail.setFoodName(foodName);
//                orderDetail.setFoodPrice(foodPrice);
//            }

            if (order.getOrderDetailList().stream().anyMatch(detail -> detail.getOdid() == null)) {
                order.setOrderDetailList(null);
            }
        }
        return ordersList;
    }
}




