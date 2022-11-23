package jproject.my_board.controller;

import jproject.my_board.domain.Member;
import jproject.my_board.exception.NotUniqueNickNameException;
import jproject.my_board.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

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
    public String joinAction(@Valid MemberForm form, BindingResult rs){
        log.info("joinAction call");
        if(rs.hasErrors()){
            log.info("same nickname");
            return "/member/joinForm";
        }
        Member m = new Member();
        m.setNickname(form.getNickname());
        m.setPassword(form.getPassword());
        memberService.join(m);
        return "redirect:/main";
    }
    @PostMapping("/member/loginAction")
    public String loginAction(Member m, Model model, HttpServletRequest request, RedirectAttributes rdt){
        log.info("call loginAction");
        HttpSession session = request.getSession();
        Member result = memberService.login(m);
        if(request == null){
            rdt.addFlashAttribute("fail","아이디 또는 비밀번호가 잘못되었습니다.");
            return "redirect:/member/loginForm";
        }else{
            session.setAttribute("user",result);
            return "redirect:/main";
        }
    }
    @GetMapping("/member/logoutAction")
    public String logoutAction(HttpServletRequest request){
        log.info("call logoutAction");
        HttpSession session = request.getSession();
        session.invalidate();
        return "redirect:/main";
    }

}
