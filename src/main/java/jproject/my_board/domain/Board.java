package jproject.my_board.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Board {

    @Id @GeneratedValue
    @Column(name = "board_id")
    private Long id;

    private String title;
    private String content;
    private LocalDateTime create_at;
    private LocalDateTime update_at;
    private boolean private_content;
    @ManyToOne(fetch = FetchType.LAZY)
    private Member member;
}
