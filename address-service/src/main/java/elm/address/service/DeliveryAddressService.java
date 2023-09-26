package elm.address.service;

import elm.address.domain.entity.DeliveryAddress;
import com.baomidou.mybatisplus.extension.service.IService;
import elm.common.domain.ResponseResult;

/**
* @author 1
* @description 针对表【delivery_address】的数据库操作Service
* @createDate 2023-09-12 21:48:02
*/
public interface DeliveryAddressService extends IService<DeliveryAddress> {

    /**
     * 获取当前登录用户的地址列表
     * @param userId
     * @return
     */
    ResponseResult getAddressOfUser(Integer userId);
}
