package cn.ren.marvin.giraffe.auth.repo;

import cn.ren.marvin.giraffe.auth.domain.AuthorityInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author ：marvin ren
 * @date ：Created in 1/7/2021 2:57 PM
 * @description：
 * @modified By：
 * @version: 1.0
 */
public interface AuthorityInfoRepository extends JpaRepository<AuthorityInfo, String> {
}
