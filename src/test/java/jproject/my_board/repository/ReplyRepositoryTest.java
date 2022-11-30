package jproject.my_board.repository;

import jproject.my_board.domain.Member;
import jproject.my_board.domain.Reply;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class ReplyRepositoryTest {

    @Autowired
    private ReplyRepository replyRepository;
    @Autowired
    private MemberRepository memberRepository;

    @Test
    public void add(){
        Reply reply = new Reply();
        reply.setContent("내용입니다.");
        Member member = new Member();
        member.setNickname("qwer");
        member.setPassword("12345");
        memberRepository.save(member);
        reply.setMember(member);
        replyRepository.add(reply);
//        List<Reply> all = replyRepository.findAll();
//        Assertions.assertThat(all.size()).isEqualTo(1);
    }
}