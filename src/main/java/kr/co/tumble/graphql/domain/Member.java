package kr.co.tumble.graphql.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

/**
 * packageName    : kr.co.tumble.graphql.domain
 * fileName       : Member
 * author         : DANIEL
 * date           : 2023-08-03
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-08-03        DANIEL       최초 생성
 */
@Builder
@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String loginId;

    private String password;

    private String name;

    @OneToMany
    @JoinColumn(name = "memberId", referencedColumnName = "id", insertable = false, updatable = false)
    private List<Role> role;

}
