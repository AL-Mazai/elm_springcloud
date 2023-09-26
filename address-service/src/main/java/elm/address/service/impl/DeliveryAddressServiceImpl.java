package elm.address.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import elm.address.domain.entity.DeliveryAddress;
import elm.address.domain.vo.AddressVo;
import elm.address.mapper.DeliveryAddressMapper;
import elm.address.service.DeliveryAddressService;
import elm.common.domain.ResponseResult;
import elm.common.utils.BeanCopyUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author 1
* @description 针对表【delivery_address】的数据库操作Service实现
* @createDate 2023-09-12 21:48:02
*/
@Service
public class DeliveryAddressServiceImpl extends ServiceImpl<DeliveryAddressMapper, DeliveryAddress>
    implements DeliveryAddressService {

    @Override
    public ResponseResult getAddressOfUser(Integer userId) {
        LambdaQueryWrapper<DeliveryAddress> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(DeliveryAddress::getUserid, userId);
        List<DeliveryAddress> deliveryAddressList = list(queryWrapper);

        //转Vo
        List<AddressVo> addressVos = BeanCopyUtils.copyBeanList(deliveryAddressList, AddressVo.class);

        return ResponseResult.okResult(addressVos);
    }
}




