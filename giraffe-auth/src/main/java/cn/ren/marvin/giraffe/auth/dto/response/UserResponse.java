package cn.ren.marvin.giraffe.auth.dto.response;

import cn.ren.marvin.giraffe.auth.dto.UserInfoDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ：marvin ren
 * @date ：Created in 1/23/2021 6:09 PM
 * @description：
 * @modified By：
 * @version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {
    UserInfoDto userInfoDto;
}
