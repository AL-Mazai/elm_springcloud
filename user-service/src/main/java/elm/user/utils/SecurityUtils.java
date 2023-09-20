package elm.user.utils;


import elm.user.domain.entity.LoginUser;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class SecurityUtils {
    /**
     * 获取用户
     **/
    public static LoginUser getLoginUser() {
        return (LoginUser) getAuthentication().getPrincipal();
    }

    /**
     * 获取Authentication
     */
    public static Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

//    public static Boolean isAdmin(){
//        Long id = getLoginUser().getUser().getUserid();
//        return id != null && id.equals(1L);
//
////        String type = getLoginUser().getUser().getType();
////        return type.equals("1");
//    }

    public static String getUserId() {
        return getLoginUser().getUser().getUserid();
    }
}
