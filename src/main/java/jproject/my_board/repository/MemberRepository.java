package jproject.my_board.repository;

import jproject.my_board.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRepository {

    private final EntityManager em;

    public void save(Member m){
        em.persist(m);
    }

    public Member findOne(Long id){
        return em.find(Member.class, id);
    }

   public Member checkUser(Member m){
       Object singleResult = em.createQuery("select m from Member m where m.nickname = :nickname and m.password = :password")
               .setParameter("nickname", m.getNickname())
               .setParameter("password", m.getPassword())
               .getSingleResult();
       return (Member) singleResult;

   }

}
