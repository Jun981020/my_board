package jproject.my_board.service;

import jproject.my_board.domain.Member;
import jproject.my_board.exception.NotUniqueNickNameException;
import jproject.my_board.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Slf4j
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    //회원가입
    public void join(Member m){
        checkValidateUniqueNickName(m.getNickname());
        memberRepository.save(m);
    }
    //회원 로그인
    public Member login(Member m){
        Member member = memberRepository.checkUser(m);
        log.info(member.toString());
        return member;
    }

    public void checkValidateUniqueNickName(String nickName){
        List<Member> members = memberRepository.findByNickname(nickName);
        if(!members.isEmpty()){
            throw new NotUniqueNickNameException("same nickname in database");
        }
    }

}
