package kr.co.tumble.graphql.graphql;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import kr.co.tumble.graphql.domain.Member;
import kr.co.tumble.graphql.dto.MemberDto;
import kr.co.tumble.graphql.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * packageName    : kr.co.tumble.graphql.graphql
 * fileName       : MemberQuery
 * author         : DANIEL
 * date           : 2023-08-03
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-08-03        DANIEL       최초 생성
 */
@Component
@RequiredArgsConstructor
@Transactional
public class MemberQuery implements GraphQLQueryResolver {

    private final MemberRepository memberRepository;

    public MemberDto getMember(int id) {
        Member member = memberRepository.findById(id)
                                        .orElse(null);
        return MemberDto.from(member);
    }
}