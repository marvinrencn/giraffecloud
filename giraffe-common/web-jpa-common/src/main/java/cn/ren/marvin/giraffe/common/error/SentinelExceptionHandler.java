package cn.ren.marvin.giraffe.common.error;

import cn.ren.marvin.giraffe.common.api.BaseResponse;
import cn.ren.marvin.giraffe.common.api.ResultCode;
import com.alibaba.csp.sentinel.adapter.servlet.callback.UrlBlockHandler;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeException;
import com.alibaba.csp.sentinel.slots.block.flow.FlowException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author ：marvin ren
 * @date ：Created in 1/1/2021 9:17 PM
 * @description：
 * @modified By：
 * @version: 1.0
 */

@Component
public class SentinelExceptionHandler implements UrlBlockHandler {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void blocked(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, BlockException e) throws IOException {
        // BlockException 异常接口，其子类为Sentinel五种规则异常的实现类
        // AuthorityException 授权异常
        // DegradeException 降级异常
        // FlowException 限流异常
        // ParamFlowException 参数限流异常
        // SystemBlockException 系统负载异常
        BaseResponse baseResponse = BaseResponse.builder().code(ResultCode.BLOCK_ERROR).build();
        if (e instanceof FlowException) {
            baseResponse.setMessage("sentinel flow block.");
        } else if (e instanceof DegradeException) {
            baseResponse.setMessage("sentinel degrade block.");
        } else {
            baseResponse.setMessage("sentinel block.");
        }

        httpServletResponse.setContentType("application/json;charset=utf-8");
        httpServletResponse.getWriter().write(baseResponse.getJSONString());
    }
}
