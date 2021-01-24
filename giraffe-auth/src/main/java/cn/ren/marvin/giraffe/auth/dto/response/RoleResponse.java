package cn.ren.marvin.giraffe.auth.dto.response;

import cn.ren.marvin.giraffe.auth.dto.RoleInfoDto;
import cn.ren.marvin.giraffe.common.api.BaseResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ：marvin ren
 * @date ：Created in 1/17/2021 8:28 PM
 * @description：
 * @modified By：
 * @version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleResponse extends BaseResponse {
    RoleInfoDto roleInfoDto;
}
