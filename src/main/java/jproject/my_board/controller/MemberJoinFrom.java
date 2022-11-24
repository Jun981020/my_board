package jproject.my_board.controller;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter
@Setter
public class MemberJoinFrom {

    @NotEmpty(message = "회원이름은 필수입니다.")
    private String nickname;
    @Size(min = 5,max = 20,message = "비밀번호는 5자이상 20자 이하여야 합니다.")
    private String password;
}
