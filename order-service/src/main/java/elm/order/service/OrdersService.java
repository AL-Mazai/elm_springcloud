package elm.order.service;

import elm.order.domain.entity.Orders;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author 1
* @description 针对表【orders】的数据库操作Service
* @createDate 2023-11-22 14:15:41
*/
public interface OrdersService extends IService<Orders> {

    List<Orders> getAllOrder(Integer userId);
}
