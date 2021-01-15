package cn.ren.marvin.giraffe.auth.repo;

import cn.ren.marvin.giraffe.auth.domain.DepartmentInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author ：marvin ren
 * @date ：Created in 1/7/2021 11:44 AM
 * @description：
 * @modified By：
 * @version: 1.0
 */
@Repository
public interface DepartmentInfoRepository extends JpaRepository<DepartmentInfo, String> {

}
