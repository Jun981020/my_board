package jproject.my_board.service;

import jproject.my_board.domain.Board;
import jproject.my_board.domain.Member;
import jproject.my_board.dto.BoardDto;
import jproject.my_board.repository.BoardRepository;
import jproject.my_board.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;
    public List<Board> getBoardList(){
        List<Board> list = boardRepository.list();
        List<BoardDto> dto = new ArrayList<>();

        return list;
    }

    public void insertContent(Board board) {
        board.setCreate_at(LocalDateTime.now());
        boardRepository.save(board);
    }
    public Board getOneBoard(Long id){
        Board one = boardRepository.findOne(id);
        return one;
    }

    public String getOneMemberOfBoardId(Long id){
        return boardRepository.findMember(id);
    }
}
