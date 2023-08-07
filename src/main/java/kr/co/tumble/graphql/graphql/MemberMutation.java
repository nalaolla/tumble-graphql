package kr.co.tumble.graphql.graphql;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import kr.co.tumble.graphql.domain.Member;
import kr.co.tumble.graphql.domain.Role;
import kr.co.tumble.graphql.dto.MemberDto;
import kr.co.tumble.graphql.repository.MemberRepository;
import kr.co.tumble.graphql.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * packageName    : kr.co.tumble.graphql.graphql
 * fileName       : MemberMutation
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
public class MemberMutation implements GraphQLMutationResolver {

    private final MemberRepository memberRepository;

    private final RoleRepository roleRepository;

    public MemberDto createMember(MemberDto memberDto) {
        Member member = memberRepository.save(Member.builder()
                                                    .loginId(memberDto.getLoginId())
                                                    .name(memberDto.getName())
                                                    .password(memberDto.getPassword())
                                                    .build());
        return MemberDto.from(member);
    }

    public Boolean deleteMember(int id){
        Optional<Member> optionalMember = memberRepository.findById(id);
        Role role = roleRepository.findByMemberId(id);
        if(optionalMember.isPresent()) {
            roleRepository.delete(role);
            memberRepository.delete(optionalMember.get());
        }
        return true;
    }
}