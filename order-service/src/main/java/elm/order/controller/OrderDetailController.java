package elm.order.controller;

import elm.order.domain.entity.OrderDetail;
import elm.order.service.OrderDetailService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (OrderDetail)表控制层
 *
 * @author makejava
 * @since 2023-11-22 14:34:45
 */
@RestController
@RequestMapping("orderDetail")
public class OrderDetailController {
    /**
     * 服务对象
     */
    @Resource
    private OrderDetailService orderDetailService;

}

