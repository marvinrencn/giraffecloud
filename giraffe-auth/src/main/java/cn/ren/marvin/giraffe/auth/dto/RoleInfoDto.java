package cn.ren.marvin.giraffe.auth.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

/**
 * @author ：marvin ren
 * @date ：Created in 1/17/2021 8:21 PM
 * @description：
 * @modified By：
 * @version: 1.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RoleInfoDto {
    private String id;
    private String name;
    private String code;
    private int site;
    private int state;
    private String notes;

    private Set<String>  resourceIds;
}
