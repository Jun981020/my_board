package jproject.my_board.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Member {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MEMBER_ID")
    private Long id;
    @Column(unique = true)
    private String nickname;
    private String password;

    private LocalDateTime join_date;
    //우선은 단반향 매핑으로 member 객체에서 boards를 알필요는 없다 판단.
//    @OneToMany(mappedBy = "member")
//    private List<Board> boards = new ArrayList<>();

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", nickname='" + nickname + '\'' +
                ", password='" + password + '\'' +
                ", join_date=" + join_date +
                '}';
    }
}
