package elm.business.controller;


import elm.business.domain.entity.BusinessType;
import elm.common.domain.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import elm.business.service.BusinessTypeService;

import javax.annotation.Resource;
import java.util.List;

/**
 * 商家类型(BusinessType)表控制层
 *
 * @author makejava
 * @since 2023-09-27 15:55:56
 */
@Slf4j
@RestController
@RequestMapping("/businessType")
public class BusinessTypeController {
    /**
     * 服务对象
     */
    @Resource
    private BusinessTypeService businessTypeService;

    @GetMapping("/getAllType")
    public ResponseResult getAllBusinessType(){
        List<BusinessType> businessTypeList = businessTypeService.list();
        return ResponseResult.okResult(businessTypeList);
    }

}

