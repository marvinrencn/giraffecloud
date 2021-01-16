package cn.ren.marvin.giraffe.auth.repo;

import cn.ren.marvin.giraffe.auth.domain.DepartmentInfo;
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
public interface DepartmentInfoRepository extends JpaRepository<DepartmentInfo, String> {

    @Query(value = "select * from auth_department_info where name like ?1 or mobile like ?1 or email like ?1", nativeQuery = true)
    List<DepartmentInfo> searchUserBySearchText(String search_text);
}
