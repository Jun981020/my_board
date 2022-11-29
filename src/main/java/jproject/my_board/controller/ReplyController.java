package jproject.my_board.controller;

import jproject.my_board.domain.Member;
import jproject.my_board.domain.Reply;
import jproject.my_board.repository.MemberRepository;
import jproject.my_board.repository.ReplyRepository;
import jproject.my_board.service.MemberService;
import jproject.my_board.service.ReplyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;

@Controller
@Slf4j
@RequiredArgsConstructor
public class ReplyController {

    private final ReplyService replyService;
    private final MemberService memberService;
    @PostMapping("/new_reply")
    public String new_reply(@ModelAttribute ReplyForm form, int id){
        log.info("call new_reply");
        Reply reply = new Reply();
        reply.setContent(form.getContent());
        reply.setCreate_at(LocalDateTime.now());
        reply.setMember(memberService.oneMemberByName(form.getNickname()));
        replyService.insertReply(reply);
        return "redirect:/board/board_one/"+id;
    }
}
