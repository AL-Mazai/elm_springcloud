package elm.user.domain.vo;

import elm.user.domain.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.checkerframework.checker.guieffect.qual.UI;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginVo {

    private String token;
    private UserInfoVo userInfoVo;
}
