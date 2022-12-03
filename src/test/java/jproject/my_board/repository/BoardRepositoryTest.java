package jproject.my_board.repository;

import jproject.my_board.domain.Board;
import jproject.my_board.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;


import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@Transactional
class BoardRepositoryTest {

    @Autowired
    private BoardRepository boardRepository;


    @Test
    public void list(){
        Board board = new Board();
        board.setTitle("제목입니다.");
        board.setContent("내용입니다.");
        List<Board> list = boardRepository.list();
        assertThat(list).isEmpty();
    }

    @Test
    public void save(){
        Member member = new Member();
        member.setNickname("주녕");
        Board board = new Board();
        board.setTitle("제목입니다.");
        board.setContent("내용입니다.");
        board.setPrivate_content(0);
        board.setCreate_at(LocalDateTime.now());
//        Long save = boardRepository.save(board);
//        Assertions.assertThat(save).isEqualTo(board.getId());
    }
    @Test
    public void findOne(){
        Board board = new Board();
        board.setTitle("제목입니다.");
        board.setContent("내용입니다.");
        board.setPrivate_content(0);
        board.setCreate_at(LocalDateTime.now());
//        Board one = boardRepository.findOne(save);
//        Assertions.assertThat(board).isSameAs(one);
    }
    @Test
    public void delete(){
        Member member = new Member();
        member.setNickname("주녕");
        Board board1 = new Board();
        board1.setTitle("제목입니다.");
        board1.setContent("내용입니다.");
        board1.setPrivate_content(0);
        board1.setCreate_at(LocalDateTime.now());
        boardRepository.remove(board1);
        Board one = boardRepository.findOne(board1.getId());
        System.out.println("one = " + one);

    }





}