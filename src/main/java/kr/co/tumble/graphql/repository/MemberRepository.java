package kr.co.tumble.graphql.repository;

import kr.co.tumble.graphql.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * packageName    : kr.co.tumble.graphql.repository
 * fileName       : MemberRepository
 * author         : DANIEL
 * date           : 2023-08-03
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-08-03        DANIEL       최초 생성
 */
@Repository
public interface MemberRepository extends JpaRepository<Member, Integer> {
}