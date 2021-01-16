package cn.ren.marvin.giraffe.auth.dto.response;

import cn.ren.marvin.giraffe.auth.dto.DepartmentDto;
import cn.ren.marvin.giraffe.common.api.BaseResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ：marvin ren
 * @date ：Created in  2021-01-15 下午8:52
 * @description：
 * @modified By：
 * @version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentResponse extends BaseResponse {
    DepartmentDto data;
}
