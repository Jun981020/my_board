package jproject.my_board.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Arrays;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BoardDto {
    private int board_id;
    private String user_id;
    private String board_title;
    private LocalDateTime board_create_at;
    private int private_content;

}
