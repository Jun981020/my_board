package jproject.my_board.service;

import jproject.my_board.domain.Member;
import jproject.my_board.repository.MemberRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class MemberServiceTest {

    @Autowired private MemberRepository memberRepository;
    @Autowired private MemberService memberService;

    @Test
    public void join(){
        Member member = new Member();
        member.setPassword("1234");
        memberRepository.save(member);
        Long id = memberService.join(member);
        Assertions.assertEquals(member,memberRepository.findOne(id));

    }





}