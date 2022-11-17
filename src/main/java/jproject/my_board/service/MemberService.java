package jproject.my_board.service;

import jproject.my_board.domain.Member;
import jproject.my_board.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class MemberService {

    private final MemberRepository memberRepository;

    public Long join(Member m){
        memberRepository.save(m);
        return m.getId();
    }

    public Member login(Member m){
        Member member = memberRepository.checkUser(m);
        log.info(member.toString());
        return member;
    }




}
