package jproject.my_board.service;

import jproject.my_board.domain.Board;
import jproject.my_board.dto.BoardDto;
import jproject.my_board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;
    //게시글 전체조회
    public List<Board> getBoardList(){
        List<Board> list = boardRepository.list();
        List<BoardDto> dto = new ArrayList<>();

        return list;
    }

    @Transactional
    //게시글 추가
    public void insertContent(Board board) {
        boardRepository.save(board);
    }
    //게시글 하나 조회
    public Board getOneBoard(Long id){
        Board one = boardRepository.findOne(id);
        return one;
    }

    //게시글 번호의 memberNickname 조회
    public String getOneMemberNicknameOfBoardId(Long id){
        return boardRepository.findMember(id);
    }
}
