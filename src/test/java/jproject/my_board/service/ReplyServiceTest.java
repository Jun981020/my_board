package jproject.my_board.service;

import jproject.my_board.domain.Board;
import jproject.my_board.domain.Member;
import jproject.my_board.domain.Reply;
import jproject.my_board.repository.BoardRepository;
import jproject.my_board.repository.MemberRepository;
import jproject.my_board.repository.ReplyRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class ReplyServiceTest {

    @Autowired
    private ReplyRepository replyRepository;
    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private BoardRepository boardRepository;

    @Test
    public void addTest(){
        Member member = new Member();
        member.setNickname("qwer");
        member.setPassword("12345");
        memberRepository.save(member);

        Board board = new Board();
        board.setContent("내용입니다.");
        board.setTitle("제목입니다.");
        board.setCreate_at(LocalDateTime.now());
        board.setMember(member);
        boardRepository.save(board);

        Reply reply = new Reply();
        reply.setCreate_at(LocalDateTime.now());
        reply.setMember(member);
        reply.setContent("어쩔티비ㅋㅋ");
        replyRepository.add(reply);
//        List<Reply> all = replyRepository.findAll();
//        Assertions.assertThat(all.size()).isEqualTo(1);
//        all.stream().forEach(System.out::println);
    }

    @Test
    public void my_test(){
        Member member = new Member();
        member.setNickname("qwerww");
        member.setPassword("12345");
        memberRepository.save(member);

        Board board = new Board();
        board.setContent("할리갈리");
        board.setTitle("제목입니다.");
        board.setCreate_at(LocalDateTime.now());
        board.setMember(member);
        boardRepository.save(board);


        Member m = memberRepository.findByNicknameOne(member.getNickname());
        Board b = boardRepository.findOne(board.getId());

        Reply reply = new Reply();
        reply.setContent("하하오오오우루루");
        reply.setMember(m);
        reply.setBoard(b);
        reply.setCreate_at(LocalDateTime.now());
        replyRepository.add(reply);

        List<Reply> all = replyRepository.findAll(b.getId());
        all.stream().forEach(System.out::println);

    }
}