package elm.address.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import elm.address.domain.entity.DeliveryAddress;
import elm.address.mapper.DeliveryAddressMapper;
import elm.address.service.DeliveryAddressService;
import org.springframework.stereotype.Service;

/**
* @author 1
* @description 针对表【delivery_address】的数据库操作Service实现
* @createDate 2023-09-12 21:48:02
*/
@Service
public class DeliveryAddressServiceImpl extends ServiceImpl<DeliveryAddressMapper, DeliveryAddress>
    implements DeliveryAddressService {

}




