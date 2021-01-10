package cn.ren.marvin.giraffe.common.model;

import org.springframework.data.domain.Sort;

/**
 * @author ：marvin ren
 * @date ：Created in 10/13/2020 5:33 PM
 * @description：
 * @modified By：
 * @version: 1.0
 */
public class PageRequest extends org.springframework.data.domain.PageRequest implements Pageable {

    private final String filters;

    public PageRequest(int page, int size, String filters) {
        this(page, size, filters, null);
    }

    public PageRequest(int page, int size, String filters, Sort.Direction direction, String... properties) {
        this(page, size, filters, Sort.by(direction, properties));
    }

    public PageRequest(int page, int size, String filters, Sort sort) {
        super(page, size, sort);
        this.filters = filters;
    }

    public String getFilters() {
        return filters;
    }

}
