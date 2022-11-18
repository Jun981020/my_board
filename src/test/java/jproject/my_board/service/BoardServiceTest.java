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

}