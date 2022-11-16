package jproject.my_board.repository;

import jproject.my_board.domain.Board;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class BoardRepository {

    @PersistenceContext
    private EntityManager em;

    public List<Board> list(){
        return em.createQuery("select b from Board b", Board.class).getResultList();
    }

}
