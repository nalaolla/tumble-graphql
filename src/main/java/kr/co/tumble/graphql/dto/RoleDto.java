package kr.co.tumble.graphql.dto;

import kr.co.tumble.graphql.domain.Role;
import lombok.*;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * packageName    : kr.co.tumble.graphql.dto
 * fileName       : RoleDto
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
public class RoleDto {
    private Integer id;

    private Integer memberId;

    private String role;

    public static List<RoleDto> from(Collection<Role> entities) {
        if(entities == null) {
            return null;
        }
        return entities.stream().map(RoleDto::from).collect(Collectors.toList());
    }

    public static RoleDto from(Role entity) {
        return RoleDto.builder()
                        .id(entity.getId())
                        .memberId(entity.getMemberId())
                        .role(entity.getRole())
                        .build();
    }
}