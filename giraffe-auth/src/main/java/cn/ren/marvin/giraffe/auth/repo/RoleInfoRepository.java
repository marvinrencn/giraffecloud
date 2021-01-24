package cn.ren.marvin.giraffe.auth.repo;

import cn.ren.marvin.giraffe.auth.domain.RoleInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author ：marvin ren
 * @date ：Created in 1/7/2021 11:44 AM
 * @description：
 * @modified By：
 * @version: 1.0
 */
@Repository
public interface RoleInfoRepository extends JpaRepository<RoleInfo, String> {

    @Query(value = "select * from auth_role_info where name like ?1 or code like ?1 or notes like ?1", nativeQuery = true)
    List<RoleInfo> searchRoleBySearchText(String search_text);

}
