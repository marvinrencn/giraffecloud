package cn.ren.marvin.giraffe.common.service;

import cn.ren.marvin.giraffe.common.model.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

import java.io.Serializable;
import java.util.List;

/**
 * @author ：marvin ren
 * @date ：Created in 10/13/2020 5:33 PM
 * @description：
 * @modified By：
 * @version: 1.0
 */
public interface PagingAndSortingQueryService<T, ID extends Serializable> extends PagingAndSortingService<T, ID> {

    T findOneByQuery(String filters);

    List<T> findByQuery(String filters);

    List<T> findByQuery(String filters, Sort sort);

    Page<T> pageByQuery(Pageable pageable);

    void deleteByQuery(String filters);

}
