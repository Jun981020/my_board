package jproject.my_board.controller;

import jproject.my_board.domain.Board;
import jproject.my_board.domain.Member;
import jproject.my_board.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.List;

@Controller
@Slf4j
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/board/main")
    public String main(Model model){
        List<Board> boardList = boardService.getBoardList();
        model.addAttribute("list",boardList);
        return "board";
    }

    @GetMapping("/board/write")
    public String write(){
        return "write";
    }

    @PostMapping("/board/writeAction")
    public String writeAction(BoardForm form, HttpServletRequest request){
        Object member = request.getSession().getAttribute("user");
        Member m = (Member) member;
        Board board  = new Board();
        board.setTitle(form.getTitle());
        board.setContent(form.getContent());
        board.setMember(m);
        board.setPrivate_content(form.getPrivate_content());
        board.setCreate_at(LocalDateTime.now());
        boardService.insertContent(board);
        log.info("call board/writeAction");
        return "redirect:/board/main";
    }
    @GetMapping("/board/board_one/{id}")
    public String board_one(@PathVariable("id")int id,Model model){
        Long num = Long.valueOf(id);
        Board oneBoard = boardService.getOneBoard(num);
        model.addAttribute("board",oneBoard);
        String user = boardService.getOneMemberNicknameOfBoardId(num);
        model.addAttribute("user",user);
        log.info("call board_one");
        return "board_one";
    }



}
