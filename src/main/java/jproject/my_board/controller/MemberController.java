package jproject.my_board.controller;

import jproject.my_board.domain.Member;
import jproject.my_board.exception.MemberFormValidException;
import jproject.my_board.exception.NotUniqueNickNameException;
import jproject.my_board.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.persistence.NoResultException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@Slf4j
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/member/loginform")
    public String loginForm(HttpServletRequest request){
        log.info("call loginForm");
//        Object user = request.getSession().getAttribute("user");
//        if(user != null){
////            String message = "이미 로그인 하셧습니다.";
////            request.setAttribute("message",message);
////            String path = request.getServletPath();
////            System.out.println("path = " + path);
////            return "redirect:"+path;
//
//        }else{
//            return "loginForm";
//        }
        //(무한루프 발생)....
        return "loginForm";
    }
    @GetMapping("/member/joinForm")
    public String joinForm(){
        log.info("call joinForm");
        return "joinForm";
    }
    @PostMapping("/member/joinAction")
    public String joinAction(@Valid MemberJoinFrom form, BindingResult brs){
        log.info("joinAction call");
        if(brs.hasErrors()){
            String defaultMessage = brs.getFieldError().getDefaultMessage();
            log.info("error message : " + defaultMessage);
            throw new MemberFormValidException(defaultMessage);
        }else{
            Member m = new Member();
            m.setNickname(form.getNickname());
            m.setPassword(form.getPassword());
            memberService.join(m);
            return "redirect:/main";
        }
    }
    @ExceptionHandler({NotUniqueNickNameException.class})
    public String sameNickname(RedirectAttributes rdt){
        String message = "이미가입한 닉네임 입니다. 다른 닉네임을 입력해주세요";
        rdt.addFlashAttribute("fail",message);
        log.info("call sameNickname ExceptionHandler");
        return "redirect:/member/joinForm";
    }
    @ExceptionHandler(MemberFormValidException.class)
    public String memberFormValid(RedirectAttributes rdt){
        log.info("call memberFormValid ExceptionHandler");
        String message = "회원가입 양식에 맞게 입력해주세요(회원이름은 필수입니다.),(비밀번호는 5자이상 20자 이하여야 합니다.)";
        rdt.addFlashAttribute("fail",message);
        return "redirect:/member/joinForm";

    }
    @PostMapping("/member/loginAction")
    public String loginAction(@Valid Member m, HttpServletRequest request, RedirectAttributes rdt, BindingResult brs){
        log.info("call loginAction");
        if(brs.hasErrors()){
            String message = brs.getFieldError().getDefaultMessage();
            log.info("error message: " + message);
            throw new NoResultException(message);
        }else{
            HttpSession session = request.getSession();
            Member result = memberService.login(m);
            session.setAttribute("user",result);
            return "redirect:/main";
        }
    }
    @ExceptionHandler(NoResultException.class)
    public String notFindUserException(RedirectAttributes rdt){
        log.info("noResultException Handler call");
        String message = "아이디 또는 비밀번호가 잘못되었습니다.";
        rdt.addFlashAttribute("fail",message);
        return "redirect:/member/loginform";
    }
    @GetMapping("/member/logoutAction")
    public String logoutAction(HttpServletRequest request){
        log.info("call logoutAction");
        HttpSession session = request.getSession();
        session.invalidate();
        return "redirect:/main";
    }

}
