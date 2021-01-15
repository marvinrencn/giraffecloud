package cn.ren.marvin.giraffe.auth.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ：marvin ren
 * @date ：Created in 1/8/2021 3:30 PM
 * @description：
 * @modified By：
 * @version: 1.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserInfoDto {

    private String id;

    private String username;

    private Integer status;

    private String displayName;

    private String mobile;

    private String email;

    private String authorityCodes;
}
