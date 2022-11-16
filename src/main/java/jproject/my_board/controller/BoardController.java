package jproject.my_board.controller;

import jproject.my_board.domain.Board;
import jproject.my_board.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@Slf4j
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/board/main")
    public String main(Model model){
        return "board";
    }

    @GetMapping("/board/write")
    public String write(){
        return "write";
    }
    @PostMapping("/board/writeAction")
    public String writeAction(Board board){
        boardService.insertContent(board);
        return "main";
    }



}
