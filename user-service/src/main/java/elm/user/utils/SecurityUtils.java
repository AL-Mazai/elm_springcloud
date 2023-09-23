package elm.user.utils;


import elm.user.domain.entity.LoginUser;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

public class SecurityUtils {

    /**
     * 获取Authentication
     */
    public static Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    /**
     * 获取用户
     **/
    public static LoginUser getLoginUser() {
        return (LoginUser) getAuthentication().getPrincipal();
    }


    /**
     * 获取当前登录用户id
     * @return
     */
    public static Integer getUserId() {
        return getLoginUser().getUser().getUserid();
    }
}
