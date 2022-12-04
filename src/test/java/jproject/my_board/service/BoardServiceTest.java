package jproject.my_board.service;

import jproject.my_board.domain.Board;
import jproject.my_board.domain.Member;
import jproject.my_board.repository.BoardRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;


@SpringBootTest
@Transactional
class BoardServiceTest {

    @Autowired
    private BoardService boardService;
    @Autowired
    private BoardRepository boardRepository;
    @Autowired
    private MemberService memberService;

    @Test
    public void list(){
        Member member = new Member();
        member.setNickname("judwqdn");
        member.setPassword("1234");
        memberService.join(member);
        Board board = new Board();
        board.setContent("내용입니다.");
        board.setTitle("제목입니다.");
        board.setCreate_at(LocalDateTime.now());
        board.setMember(member);
        boardRepository.save(board);
        List<Board> list = boardRepository.list();
        list.stream().forEach(System.out::println);
        Assertions.assertThat(list.size()).isEqualTo(1);
    }
//    @Test
//    public void modifyTest(){
//        Board board = new Board();
//        board.setPrivate_content(1);
//        board.setTitle("기존제목");
//        board.setContent("기존내용");
//        board.setCreate_at(LocalDateTime.now());
//        boardService.insertContent(board);
//
//        board.setTitle("새로운제목");
//        board.setContent("새로운내용");
//        boardRepository.modify(1L,board);
//        Assertions.assertThat(board.getTitle()).isEqualTo("새로운제목");
//    }

    @Test
    public void delete(){
        Member member = new Member();
        member.setNickname("주녕");
        memberService.join(member);
        Board board1 = new Board();
        board1.setTitle("제목입니다.");
        board1.setContent("내용입니다.");
        board1.setPrivate_content(0);
        board1.setCreate_at(LocalDateTime.now());
        boardRepository.save(board1);
        boardRepository.remove(board1);
        Board one = boardRepository.findOne(board1.getId());
        Assertions.assertThat(one).isNull();

    }
}