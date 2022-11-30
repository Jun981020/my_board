package jproject.my_board.service;

import jproject.my_board.controller.ReplyForm;
import jproject.my_board.domain.Board;
import jproject.my_board.domain.Member;
import jproject.my_board.domain.Reply;
import jproject.my_board.repository.BoardRepository;
import jproject.my_board.repository.MemberRepository;
import jproject.my_board.repository.ReplyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ReplyService {

    private final ReplyRepository replyRepository;
    private final MemberRepository memberRepository;
    private final BoardRepository boardRepository;

//    @Transactional
//    public void insertReply(Reply reply){
//        replyRepository.add(reply);
//    }
    @Transactional
    public void insertReply(ReplyForm form){
        Member m = memberRepository.findByNicknameOne(form.getNickname());
        Board b = boardRepository.findOne((long) form.getBoard_id());

        Reply reply = new Reply();
        reply.setContent(form.getContent());
        reply.setMember(m);
        reply.setBoard(b);
        reply.setCreate_at(LocalDateTime.now());
        replyRepository.add(reply);
    }

}
