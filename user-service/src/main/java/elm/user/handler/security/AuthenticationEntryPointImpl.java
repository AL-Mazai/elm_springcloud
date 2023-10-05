package elm.user.handler.security;

import com.alibaba.fastjson.JSON;
import elm.common.domain.ResponseResult;
import elm.common.enums.AppHttpCodeEnum;
import elm.common.utils.WebUtils;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 认证失败处理器
 */
@Component
public class AuthenticationEntryPointImpl implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        authException.printStackTrace();
        ResponseResult result = null;

        if (authException instanceof BadCredentialsException) {
            // 处理密码错误的情况
            result = ResponseResult.errorResult(AppHttpCodeEnum.LOGIN_ERROR.getCode(), authException.getMessage());
        } else if (authException instanceof InsufficientAuthenticationException) {
            // 处理需要重新登录的情况
            result = ResponseResult.errorResult(AppHttpCodeEnum.NEED_LOGIN);
        } else if (authException instanceof InternalAuthenticationServiceException) {
            // 处理用户不存在的情况
            result = ResponseResult.errorResult(AppHttpCodeEnum.USER_NOT_FOUND.getCode(), authException.getMessage());
        } else {
            // 处理其他身份验证异常
            result = ResponseResult.errorResult(AppHttpCodeEnum.SYSTEM_ERROR.getCode(), "认证或授权失败");
        }


        //响应给前端
        WebUtils.renderString(response, JSON.toJSONString(result));
    }
}
