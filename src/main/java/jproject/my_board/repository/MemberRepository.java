package jproject.my_board.repository;

import jproject.my_board.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRepository {

    private final EntityManager em;

    //회원가입
    public void save(Member m){
        em.persist(m);
    }

    //회원 하나 조회
    public Member findOne(Long id){
        return em.find(Member.class, id);
    }

    //아이디와 비밀번호를 받아 저장된 회원인지 확인
   public Member checkUser(Member m){
       Object singleResult = em.createQuery("select m from Member m where m.nickname = :nickname and m.password = :password")
               .setParameter("nickname", m.getNickname())
               .setParameter("password", m.getPassword())
               .getSingleResult();
       return (Member) singleResult;
   }
   public List<Member> findByNickname(String name){
        return em.createQuery("select m from Member m where m.nickname = :name",Member.class)
                .setParameter("name",name)
                .getResultList();
   }
   public Member findByNicknameOne(String name){
        return em.createQuery("select m from Member m where m.nickname = :name",Member.class)
                .setParameter("name",name)
                .getSingleResult();
   }

}
