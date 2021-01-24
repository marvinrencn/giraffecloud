package cn.ren.marvin.giraffe.auth.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

/**
 * @author ：marvin ren
 * @date ：Created in 1/7/2021 1:35 PM
 * @description：
 * @modified By：
 * @version: 1.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "auth_role_info")
public class RoleInfo implements GrantedAuthority {
    @Id
    @GenericGenerator(name = "idGenerator", strategy = "uuid")
    @GeneratedValue(generator = "idGenerator")
    private String id;
    private String name;
    @Column(unique = true)
    private String code;
    private int site;
    private int state;
    private String notes;


    @ManyToMany(mappedBy = "roleInfos", fetch = FetchType.LAZY)
    private List<UserInfo> userInfos;

    @ManyToMany(mappedBy = "roleInfos", fetch = FetchType.LAZY)
    private List<UserInfo> departmentInfos;


    @ManyToMany(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    @JoinTable(name = "auth_user_resource_rel",
            inverseJoinColumns = @JoinColumn(name = "resource_id"),
            joinColumns = @JoinColumn(name = "role_id"))
    private Set<ResourceInfo> resourceInfos;

    @Override
    public String getAuthority() {
        return code;
    }
}
