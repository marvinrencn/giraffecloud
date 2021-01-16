package cn.ren.marvin.giraffe.auth.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author ：marvin ren
 * @date ：Created in  2021-01-15 下午5:07
 * @description：
 * @modified By：
 * @version: 1.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentDto {
    private String id;
    private String name;
    private String leader;
    private String mobile;
    private String email;
    private int status;
    private String notes;
    private String parentId;
    private String parentName;
    private List<DepartmentDto> children;
}
