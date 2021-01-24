package cn.ren.marvin.giraffe.auth.repo;

import cn.ren.marvin.giraffe.auth.domain.ResourceInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author ：marvin ren
 * @date ：Created in 1/23/2021 9:34 PM
 * @description：
 * @modified By：
 * @version: 1.0
 */

@Repository
public interface ResourceInfoRepository extends JpaRepository<ResourceInfo, String> {
}
