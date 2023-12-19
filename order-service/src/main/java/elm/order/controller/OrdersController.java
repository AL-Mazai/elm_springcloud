package elm.order.controller;


import elm.common.domain.ResponseResult;
import elm.order.domain.entity.OrderDetail;
import elm.order.domain.entity.Orders;
import elm.order.service.OrderDetailService;
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
    @Resource
    private OrderDetailService orderDetailService;

    @GetMapping("/getAllOrders")
    public ResponseResult getAllOrders(@RequestParam("userId") Integer userId){
        System.out.println("userId：" + userId);
        List<Orders> ordersList = ordersService.getAllOrder(userId);
        return ResponseResult.okResult(ordersList);
    }

    @PostMapping("/saveOrders")
    public ResponseResult saveOrders(@RequestBody Orders orders){
        ordersService.save(orders);

        //save将实体保存到数据后，会自动为orders的主键Id赋值（前提是要在实体中主键id上打@TableId注解）
        System.out.println(orders.getOrderid());
        List<OrderDetail> orderDetailList = orders.getOrderDetailList();
        for(OrderDetail orderDetail: orderDetailList){
            orderDetail.setOrderid(orders.getOrderid());
            System.out.println(orderDetail.toString());
            //保存订单细节
            orderDetailService.save(orderDetail);
        }
        return ResponseResult.okResult();
    }

}

