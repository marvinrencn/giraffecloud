package cn.ren.marvin.giraffe.auth.repo;

import cn.ren.marvin.giraffe.auth.model.UserInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author ：marvin ren
 * @date ：Created in 1/7/2021 11:44 AM
 * @description：
 * @modified By：
 * @version: 1.0
 */
@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo, String> {

    public Optional<UserInfo> findUserInfoByUsername(String name);

    @Query(value = "select * from auth_user_info where username like ?1 or display_name like ?1 or mobile like ?1 or email like ?1 ORDER BY ?#{#pageable}",
    countQuery = "select count(*) from auth_user_info where username like ?1 or display_name like ?1 or mobile like ?1 or email like ?1",
            nativeQuery = true)
    Page<UserInfo> searchUserBySearchtext(String search_text, Pageable pageable);
}
