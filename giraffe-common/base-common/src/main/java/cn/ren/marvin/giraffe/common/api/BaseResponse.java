package cn.ren.marvin.giraffe.common.api;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ：marvin ren
 * @date ：Created in 12/22/2020 11:56 AM
 * @description：
 * @modified By：
 * @version: 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BaseResponse {
    private String message;
    @Builder.Default
    private ResultCode code = ResultCode.SUCCESS;

    public boolean isSuccess() {
        return code == ResultCode.SUCCESS;
    }

    public String getJSONString(){
        return "{ code: " + code.getCode() + ", message: '" + message + "'}";
    }
}
