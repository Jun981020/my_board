package jproject.my_board.controller;

import jproject.my_board.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller("/")
@Slf4j
@RequiredArgsConstructor
public class HelloController {

    private final MemberService memberService;

    @GetMapping(value = {"main","/"})
    public String main(){
        log.info("call main");
        return "main";
    }
    @GetMapping("board")
    public String board(){
        log.info("call board");
        return "board";
    }
    @GetMapping("content")
    public String content(){
        log.info("call content");
        return "content";
    }


}
