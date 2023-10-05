package elm.address.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import elm.address.domain.entity.DeliveryAddress;
import elm.address.service.DeliveryAddressService;
import elm.common.domain.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.jni.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/address")
public class AddressController {

    @Resource
    private DeliveryAddressService addressService;

    @GetMapping("/getAllAddress")
    public ResponseResult getAllAddress(@RequestParam("userId") Integer userId){
        return addressService.getAddressOfUser(userId);
    }

    @PostMapping("/addAddress")
    public ResponseResult addAddress(@RequestBody DeliveryAddress address){
        addressService.save(address);
        return ResponseResult.okResult();
    }

    @DeleteMapping("/deleteAddress")
    public ResponseResult deleteAddress(@RequestParam("addressId") Integer addressId){
        addressService.removeById(addressId);
        return ResponseResult.okResult();
    }

    @PutMapping("/updateAddress")
    public ResponseResult updateAddress(@RequestBody DeliveryAddress address){
        addressService.updateById(address);
        return ResponseResult.okResult();
    }
}
