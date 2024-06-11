package elm.back.service;

import elm.common.domain.ResponseResult;
import org.springframework.web.multipart.MultipartFile;

public interface OSSUploadService {

    /**
     * 七牛云对象存储上传头像
     * @param file
     * @return
     */
    ResponseResult uploadImg(MultipartFile file);
}
