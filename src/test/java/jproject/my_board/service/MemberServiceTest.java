package jproject.my_board.service;

import jproject.my_board.domain.Member;
import jproject.my_board.exception.NotUniqueNickNameException;
import jproject.my_board.repository.MemberRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
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
        memberService.join(member);
//        Assertions.assertEquals(member,memberRepository.findOne(id));
    }

    @Test
    public void login(){
        memberRepository.delete();
        Member m = new Member();
        m.setNickname("qwer");
        m.setPassword("1234");
        assertThrows(EmptyResultDataAccessException.class,() ->
                        memberRepository.checkUser(m)
                );

//        Member m1 = new Member();
//        m1.setId(1L);
//        m1.setNickname("qwer");
//        m1.setPassword("1234");
//        Member getMember1 = memberRepository.checkUser(m1);
//        assertThat(m1.getNickname()).isEqualTo(getMember1.getNickname());
    }
    @Test
    public void checkSameNickName(){
        Member m1 = new Member();
        m1.setNickname("qwer");
        m1.setPassword("1234");
        memberRepository.save(m1);

        Member m2 = new Member();
        m2.setNickname("qwer");
        m2.setPassword("1234");

        assertThrows(NotUniqueNickNameException.class,() ->
                        memberService.join(m2)
                );

    }





}