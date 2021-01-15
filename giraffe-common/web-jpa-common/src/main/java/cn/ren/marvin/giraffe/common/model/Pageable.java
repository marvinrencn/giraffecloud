package cn.ren.marvin.giraffe.common.model;

/**
 * @author ：marvin ren
 * @date ：Created in 10/13/2020 5:31 PM
 * @description：
 * @modified By：
 * @version: 1.0
 */
public interface Pageable extends org.springframework.data.domain.Pageable {
    String getFilters();
}
