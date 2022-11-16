package jproject.my_board.repository;

import jproject.my_board.domain.Board;
import jproject.my_board.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class BoardRepositoryTest {

    @PersistenceContext
    private EntityManager em;

    @Autowired
    private BoardRepository boardRepository;


    @Test
    public void list(){
        Board board = new Board();
        board.setTitle("제목입니다.");
        board.setContent("내용입니다.");
        List<Board> list = boardRepository.list();
        Assertions.assertThat(list).isEmpty();
    }



}