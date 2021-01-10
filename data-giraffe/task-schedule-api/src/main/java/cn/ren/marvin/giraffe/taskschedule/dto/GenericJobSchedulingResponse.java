package cn.ren.marvin.giraffe.taskschedule.dto;

import cn.ren.marvin.giraffe.common.api.BaseResponse;
import lombok.*;

/**
 * @author ：marvin ren
 * @date ：Created in 12/25/2020 5:56 PM
 * @description：
 * @modified By：
 * @version: 1.0
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class GenericJobSchedulingResponse extends BaseResponse {
    JobSchedulingDto data;
}
