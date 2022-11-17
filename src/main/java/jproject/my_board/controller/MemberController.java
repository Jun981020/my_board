package jproject.my_board.controller;

import jproject.my_board.domain.Member;
import jproject.my_board.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/member/loginform")
    public String loginForm(){
        log.info("call loginForm");
        return "loginForm";
    }
    @GetMapping("/member/joinForm")
    public String joinForm(){
        log.info("call joinForm");
        return "joinForm";
    }
    @PostMapping("/member/joinAction")
    public String joinAction(Member m){
        log.info("joinAction call");
        Long join = memberService.join(m);
        return "redirect:/main";
    }
    @PostMapping("/member/loginAction")
    public String loginAction(Member m, Model model){
        Member result = memberService.login(m);
        model.addAttribute("userCheck",result);
        log.info("call login Action");
        return "main";
    }

}
