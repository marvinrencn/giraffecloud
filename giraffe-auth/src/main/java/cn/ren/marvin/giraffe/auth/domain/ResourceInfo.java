package cn.ren.marvin.giraffe.auth.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

/**
 * @author ：marvin ren
 * @date ：Created in 1/16/2021 7:53 PM
 * @description：
 * @modified By：
 * @version: 1.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "auth_resource_info")
public class ResourceInfo {
    @Id
    @GenericGenerator(name = "idGenerator", strategy = "uuid")
    @GeneratedValue(generator = "idGenerator")
    private String id;
    private String name;
    private String path;
    private int site;

    @ManyToMany(mappedBy = "resourceInfos", fetch = FetchType.LAZY)
    private List<RoleInfo> roleInfos;
}
