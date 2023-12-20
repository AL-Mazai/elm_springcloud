package elm.business.controller;

import elm.business.domain.entity.Business;
import elm.business.service.BusinessService;
import elm.common.domain.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/business")
public class BusinessController {
    @Resource
    private BusinessService businessService;

    @GetMapping("/getAllBusiness")
    public ResponseResult getAllBusiness(@RequestParam("sortWay") String sortWay){
        List<Business> businessList = businessService.getAllBusiness(sortWay);
        return ResponseResult.okResult(businessList);
    }

    @GetMapping("getAllBusinessOfType")
    public ResponseResult getAllBusinessOfType(@RequestParam("typeId") Integer typeId){
        List<Business> businessList = businessService.listById(typeId);
        return ResponseResult.okResult(businessList);
    }

    @GetMapping("/getAllBusinessByName")
    public ResponseResult getAllBusinessByName(@RequestParam("businessName") String businessName){
        List<Business> businessList = businessService.listByName(businessName);
        return ResponseResult.okResult(businessList);
    }

    @GetMapping("/getBusinessInfo")
    public ResponseResult getBusinessInfo(@RequestParam("businessId") Integer businessId){
        Business business = businessService.getById(businessId);
        return ResponseResult.okResult(businessId);
    }
}
