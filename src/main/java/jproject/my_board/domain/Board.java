package jproject.my_board.domain;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Board {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String title;
    @NotNull
    private String content;
    private LocalDateTime create_at;
    private LocalDateTime update_at;
    private int private_content;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MEMBER_ID")
    @NotNull
    private Member member;

    //Builder.Default
    @Builder.Default
    @OneToMany(mappedBy = "board", cascade = CascadeType.ALL)
    private List<Reply> replies = new ArrayList<>();

    private String private_content_password;

//    public void addReplies(Reply reply){
//        replies.add(reply);
//        reply.setBoard(this);
//    }


//    @Override
//    public String toString() {
//        return "Board{" +
//                "id=" + id +
//                ", title='" + title + '\'' +
//                ", content='" + content + '\'' +
//                ", create_at=" + create_at +
//                ", update_at=" + update_at +
//                ", private_content=" + private_content +
//                ", member=" + member +
//                ", replies=" + replies +
//                '}';
//    }
}
