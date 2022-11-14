package jproject.my_board.repository;

import jproject.my_board.domain.Member;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class MemberRepository {

    @PersistenceContext
    private EntityManager em;

    public void save(Member m){
        em.persist(m);
    }

    public Member findOne(Long id){
        return em.find(Member.class, id);
    }

    //DB에서 회원이름 조회
    public boolean validateNickName(Member m){
        List<Member> resultList = em.createQuery("select m Member m where m.nickname = :name", Member.class)
                .setParameter("name",m.getNickname())
                .getResultList();
        if(resultList.isEmpty()){
            return true;
        }return false;
    }

}
