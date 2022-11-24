package jproject.my_board.controller;

import jproject.my_board.domain.Member;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class BoardForm {

    @NotEmpty(message = "제목을 입력해주세요")
    private String title;
    @NotEmpty(message = "게시글을 입력해주세요")
    private String content;
    private Member member;
    private int private_content;
}
