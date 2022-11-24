package jproject.my_board.controller;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class MemberLoginForm {

    @NotEmpty(message = "닉네임을 입력해주세요")
    private String nickname;
    @NotEmpty(message = "비밀번호를 입력해주세요")
    private String password;
}
