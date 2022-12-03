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

    //전체 게시글 가져오기
    public List<Board> list(){
        return em.createQuery("select b from Board b", Board.class).getResultList();
    }
    //게시글 하나 저장
    public void save(Board b){
        em.persist(b);
    }
    //게시글 하나 가져오기
    public Board findOne(Long id){
        return  em.find(Board.class,id);
    }
    //게시글 번호의 member 객체 가져오기
    public String findMember(Long id){
        return findOne(id).getMember().getNickname();
    }
    //게시글 삭제
    public void remove(Board board){
        em.remove(board);
    }
}
