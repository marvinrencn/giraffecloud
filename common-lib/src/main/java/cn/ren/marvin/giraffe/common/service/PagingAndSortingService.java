package cn.ren.marvin.giraffe.common.service;

import cn.ren.marvin.giraffe.common.model.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

import java.io.Serializable;

/**
 * @author ：marvin ren
 * @date ：Created in 10/13/2020 5:33 PM
 * @description：
 * @modified By：
 * @version: 1.0
 */
public interface PagingAndSortingService<T, ID extends Serializable> {

    <S extends T> S save(S entity);

    <S extends T> Iterable<S> saveAll(Iterable<S> entities);

    T findById(ID id);

    boolean existsById(ID id);

    Iterable<T> findAll();

    Iterable<T> findAllById(Iterable<ID> ids);

    long count();

    void deleteById(ID id);

    void delete(T entity);

    void deleteAll(Iterable<? extends T> entities);

    void deleteAll();

    Iterable<T> findAll(Sort sort);

    Page<T> findAll(Pageable pageable);

}
