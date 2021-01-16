package cn.ren.marvin.giraffe.common.exception;

/**
 * @author ：marvin ren
 * @date ：Created in  2021-01-15 下午9:29
 * @description：
 * @modified By：
 * @version: 1.0
 */
public class NotFoundException extends ServiceException{
    public NotFoundException(String message) {
        super(message);
    }
}
