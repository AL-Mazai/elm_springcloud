package elm.back.controller;

import elm.back.domain.entity.Admin;
import elm.back.domain.entity.User;
import elm.back.domain.vo.AdminVo;
import elm.back.domain.vo.UserInfoVo;
import elm.back.service.AdminService;
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

/**
 * (Admin)表控制层
 *
 * @author makejava
 * @since 2024-06-13 15:31:08
 */
@RestController
@RequestMapping("back_system_admin")
public class AdminController {
    /**
     * 服务对象
     */
    @Resource
    private AdminService adminService;
    @Resource
    private OSSUploadService uploadService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseResult<AdminVo> queryById(@PathVariable("id") Integer id) {
        return ResponseResult.okResult(adminService.getUserInfo(id));
    }

    @PostMapping("/login")
    public ResponseResult<AdminVo> login(@RequestBody User user){
        AdminVo loginUser = adminService.login(user);
        if (loginUser == null) {
            return ResponseResult.errorResult(AppHttpCodeEnum.LOGIN_ERROR);
        }
        System.out.println(loginUser);
        return ResponseResult.okResult(loginUser);
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

