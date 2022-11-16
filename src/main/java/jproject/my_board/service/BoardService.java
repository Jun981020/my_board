package jproject.my_board.service;

import jproject.my_board.domain.Board;
import jproject.my_board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    public List<Board> getBoardList(){
        List<Board> list = boardRepository.list();
        return list;
    }

}
