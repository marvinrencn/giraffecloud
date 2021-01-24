package cn.ren.marvin.giraffe.auth.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ：marvin ren
 * @date ：Created in 1/23/2021 8:42 PM
 * @description：
 * @modified By：
 * @version: 1.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserPasswordChangeRequest {
    String id;
    String password;
}
