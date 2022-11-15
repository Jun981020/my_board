package jproject.my_board.repository;

import jproject.my_board.domain.Board;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class BoardRepository {

    @PersistenceContext
    private EntityManager em;

    public void test(){
        em.find(Board.class,1L);
    }
}
