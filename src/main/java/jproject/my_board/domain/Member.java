package jproject.my_board.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Member {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MEMBER_ID",unique = true)
    private Long id;
    private String nickname;
    private String password;
    //우선은 단반향 매핑으로 member 객체에서 boards를 알필요는 없다 판단.
//    @OneToMany(mappedBy = "member")
//    private List<Board> boards = new ArrayList<>();

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", nickname='" + nickname + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
