package jproject.my_board.controller;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.UniqueElements;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class MemberForm {

    @NotEmpty(message = "회원이름은 필수입니다.")
    @UniqueElements
    private String nickname;
    @NotEmpty(message = "비밀번호는 필수입니다.")
    private String password;
}
