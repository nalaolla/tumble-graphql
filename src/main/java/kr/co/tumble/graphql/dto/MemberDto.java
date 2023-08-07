package kr.co.tumble.graphql.dto;

import kr.co.tumble.graphql.domain.Member;
import lombok.*;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * packageName    : kr.co.tumble.graphql.dto
 * fileName       : MemberDto
 * author         : DANIEL
 * date           : 2023-08-03
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-08-03        DANIEL       최초 생성
 */
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberDto {

    private Integer id;

    private String loginId;

    private String password;

    private String name;

    private List<RoleDto> roles;

    public static List<MemberDto> from(Collection<Member> entities) {
        return entities.stream().map(MemberDto::from).collect(Collectors.toList());
    }

    public static MemberDto from(Member entity) {
        return MemberDto.builder()
                        .id(entity.getId())
                        .loginId(entity.getLoginId())
                        .password(entity.getPassword())
                        .name(entity.getName())
                        .roles(RoleDto.from(entity.getRole()))
                        .build();
    }
}
