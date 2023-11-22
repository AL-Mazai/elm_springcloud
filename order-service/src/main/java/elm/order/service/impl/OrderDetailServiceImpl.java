package elm.order.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import elm.order.domain.entity.OrderDetail;
import elm.order.mapper.OrderDetailMapper;
import elm.order.service.OrderDetailService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * (OrderDetail)表服务实现类
 *
 * @author makejava
 * @since 2023-11-22 14:34:47
 */
@Service("orderDetailService")
public class OrderDetailServiceImpl extends ServiceImpl<OrderDetailMapper, OrderDetail> implements OrderDetailService {

}
