package elm.back.controller;

import elm.back.domain.entity.Business;
import elm.back.domain.entity.BusinessType;
import elm.back.domain.vo.BusinessVo;
import elm.back.domain.vo.UserInfoVo;
import elm.back.service.BusinessTypeService;
import elm.common.domain.ResponseResult;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (BusinessType)表控制层
 *
 * @author makejava
 * @since 2024-06-11 17:00:22
 */
@RestController
@RequestMapping("business")
public class BusinessTypeController {
    /**
     * 服务对象
     */
    @Resource
    private BusinessTypeService businessTypeService;

    @GetMapping("/getAllBusinessType")
    public ResponseResult<List<BusinessType>> getAllUser(){
        List<BusinessType> businessTypeList = businessTypeService.getAllBusinessType();
        return ResponseResult.okResult(businessTypeList);
    }

    @GetMapping("/getBusinessListByType")
    public ResponseResult<List<BusinessVo>> getBusinessListByType(@RequestParam("typeId") Integer typeId){
        List<BusinessVo> businessList = businessTypeService.getBusinessListByType(typeId);
        return ResponseResult.okResult(businessList);
    }

}

