package elm.address.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import elm.address.domain.entity.DeliveryAddress;
import elm.address.service.DeliveryAddressService;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.jni.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private DeliveryAddressService addressService;

    @GetMapping("{id}")
    public DeliveryAddress queryById(@PathVariable("id") Long id){
        LambdaQueryWrapper<DeliveryAddress> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(DeliveryAddress::getDaid, id);
        return addressService.getOne(queryWrapper);
    }

    @GetMapping("/getAllAddress")
    public List<DeliveryAddress> getAllAddress(@RequestParam("userId") String userId){
        LambdaQueryWrapper<DeliveryAddress> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(DeliveryAddress::getUserid, userId);
        List<DeliveryAddress> deliveryAddressList = addressService.list(queryWrapper);

        return deliveryAddressList;
    }


}
