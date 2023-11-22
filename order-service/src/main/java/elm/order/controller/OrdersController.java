package elm.order.controller;


import elm.common.domain.ResponseResult;
import elm.order.domain.entity.Orders;
import elm.order.service.OrdersService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Orders)表控制层
 *
 * @author makejava
 * @since 2023-11-22 14:18:52
 */
@RestController
@RequestMapping("/orders")
public class OrdersController {
    /**
     * 服务对象
     */
    @Resource
    private OrdersService ordersService;

    @GetMapping("/getAllOrders")
    public ResponseResult getAllOrders(){
        List<Orders> ordersList = ordersService.list();
        return ResponseResult.okResult(ordersList);
    }

}

