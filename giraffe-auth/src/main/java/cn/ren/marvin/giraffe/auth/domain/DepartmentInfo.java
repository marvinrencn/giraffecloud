package cn.ren.marvin.giraffe.auth.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

/**
 * @author ：marvin ren
 * @date ：Created in 1/7/2021 2:03 PM
 * @description：
 * @modified By：
 * @version: 1.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "auth_department_info")
public class DepartmentInfo {
    @Id
    @GenericGenerator(name = "idGenerator", strategy = "uuid")
    @GeneratedValue(generator = "idGenerator")
    private String id;
    private String name;


    @ManyToMany(cascade = CascadeType.REFRESH)
    @JoinTable(name = "auth_department_role_rel",
            inverseJoinColumns = @JoinColumn(name = "role_id"),
            joinColumns = @JoinColumn(name = "department_id"))
    private Set<RoleInfo> roleInfos;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "parent")
    private Set<DepartmentInfo> children;

    @ManyToOne
    private DepartmentInfo parent;

//    private Set<UserInfo> userInfos;
}
