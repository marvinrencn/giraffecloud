package cn.ren.marvin.giraffe.auth.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

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
public class RoleInfo {
    @Id
    @GenericGenerator(name = "idGenerator", strategy = "uuid")
    @GeneratedValue(generator = "idGenerator")
    private String id;
    private String name;
    private String notes;


    @ManyToMany(mappedBy = "roleInfos", fetch = FetchType.LAZY)
    private List<UserInfo> userInfos;

    @ManyToMany(mappedBy = "roleInfos", fetch = FetchType.LAZY)
    private List<UserInfo> departmentInfos;

    @Column(length=2048)
    private String authorityCodes;
}
