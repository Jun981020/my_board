package jproject.my_board.controller;

import jproject.my_board.domain.Board;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReplyForm {

    private String nickname;
    private String content;
    private int board_id;


}
