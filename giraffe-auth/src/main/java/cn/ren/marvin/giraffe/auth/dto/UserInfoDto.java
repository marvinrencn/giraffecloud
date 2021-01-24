package cn.ren.marvin.giraffe.auth.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

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

    private Integer state;

    private String displayName;

    private String mobile;

    private String email;

    private String notes;

    private Set<String> roleIds;

    private Set<String> departmentIds;

    private Set<String> roleCodes;

    private Set<String> roleNames;

    private Set<String> departmentNames;

    private String password;

    private String confirm;

}
