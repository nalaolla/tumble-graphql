package kr.co.tumble.graphql.repository;

import kr.co.tumble.graphql.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * packageName    : kr.co.tumble.graphql.repository
 * fileName       : RoleRepository
 * author         : DANIEL
 * date           : 2023-08-03
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-08-03        DANIEL       최초 생성
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role findByMemberId(int memberId);
}
