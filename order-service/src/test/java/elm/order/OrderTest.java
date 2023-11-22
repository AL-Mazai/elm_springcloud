package elm.order;

import elm.order.domain.entity.Orders;
import elm.order.mapper.OrdersMapper;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
public class OrderTest {

    @Resource
    private OrdersMapper ordersMapper;

    public void getAllOrdersTest(){
        List<Orders> ordersList = ordersMapper.selectAllOrderWithDetails();
        for (Orders o : ordersList) {
            System.out.println(o);
        }
    }
}