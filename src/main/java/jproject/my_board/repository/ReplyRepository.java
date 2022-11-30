package jproject.my_board.repository;

import jproject.my_board.domain.Reply;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ReplyRepository {

    @PersistenceContext
    private EntityManager em;

    public void add(Reply reply){
        em.persist(reply);
    }

    public List<Reply> findAll(Long board_id){
        return em.createQuery("select r from Reply r where r.board.id = :id", Reply.class)
                .setParameter("id",board_id)
                .getResultList();
    }

}
