package jproject.my_board.domain;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Board {

    @Id @GeneratedValue
    @Column(name = "board_id")
    private Long id;

    private String title;
    private String content;
    private LocalDateTime create_at;
    private LocalDateTime update_at;
    @ManyToOne(fetch = FetchType.LAZY)
    private Member member;
}
