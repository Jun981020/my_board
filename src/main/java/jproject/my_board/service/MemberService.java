package jproject.my_board.service;

import jproject.my_board.domain.Member;
import jproject.my_board.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public Long join(Member m){
        memberRepository.save(m);
        return m.getId();
    }

    public void login(Member m){
        boolean result = memberRepository.validateNickName(m);



    }




}
