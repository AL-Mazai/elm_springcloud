package elm.back.controller;

import elm.back.domain.entity.Business;
import elm.back.domain.entity.BusinessType;
import elm.back.domain.vo.BusinessVo;
import elm.back.domain.vo.UserInfoVo;
import elm.back.service.BusinessTypeService;
import elm.back.service.OSSUploadService;
import elm.common.domain.ResponseResult;
import elm.common.enums.AppHttpCodeEnum;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;
import java.util.Map;

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
    @Resource
    private OSSUploadService uploadService;

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

    @PutMapping("updateBusinessInfo")
    public ResponseResult updateBusinessInfo(@RequestBody Business business){
        int result = businessTypeService.updateBusinessInfo(business);
        if (result > 0) {
            return ResponseResult.okResult();
        }
        return ResponseResult.errorResult(AppHttpCodeEnum.SYSTEM_ERROR);
    }

    /***
     * 头像上传
     * @param file
     * @return
     * @throws IOException
     */
    @PostMapping("/upload")
    public ResponseResult uploadImg(MultipartFile file) throws IOException {
        return uploadService.uploadImg(file);
    }

}

