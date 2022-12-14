package jproject.my_board.controller;

import jproject.my_board.domain.Board;
import jproject.my_board.domain.Member;
import jproject.my_board.exception.SessionEmptyException;
import jproject.my_board.service.BoardService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

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
    public String write(HttpServletRequest request){
        log.info("call write");
        Object user = request.getSession().getAttribute("user");
        if(user == null){
            String message = "no session";
            log.info(message);
            throw new SessionEmptyException(message);
        }else{
            return "write";
        }
    }

    @ExceptionHandler(SessionEmptyException.class)
    public String sessionEmptyException(RedirectAttributes rds){
        log.info("sessionEmptyExceptionHandler call");
        String message = "로그인 하지 않으셨습니다. 우선 로그인해주세요";
        rds.addFlashAttribute("fail",message);
        return "redirect:/board/main";
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
        if(!form.getPrivate_content_password().isEmpty()){
            board.setPrivate_content_password(form.getPrivate_content_password());
        }
        boardService.insertContent(board);
        log.info("call board/writeAction");
        return "redirect:/board/main";
    }
    @GetMapping("/board/board_one/{id}")
    public String board_one(@PathVariable("id")int id,Model model){
        Long num = Long.valueOf(id);
        Board oneBoard = boardService.getOneBoard(num);
        model.addAttribute("board",oneBoard);
        model.addAttribute("id",id);
        String user = boardService.getOneMemberNicknameOfBoardId(num);
        model.addAttribute("user",user);
        log.info("call board_one");
        return "board_one";
    }
    @GetMapping("/board/modify/{id}")
    public String modify(@PathVariable("id") int id,Model model){
        log.info("modify call");
        Long num = Long.valueOf(id);
        Board oneBoard = boardService.getOneBoard(num);
        model.addAttribute("board",oneBoard);
        return  "modify";
    }
    @PostMapping("/board/modifyAction/{id}")
    public String modifyAction(@PathVariable("id") int id,Board board){
        Long num = Long.valueOf(id);
        log.info("id :" + num);
        boardService.modify(num,board);
        return "redirect:/board/main";
    }
    @PostMapping("/board/deleteAction/{id}")
    public String deleteAction(@PathVariable("id") int id){
        log.info("call delete action");
        Long num = (long) id;
        boardService.delete(num);
        return "redirect:/board/main";
    }
    @PostMapping("/board/check_private_content")
    @ResponseBody
    public boolean checkPassword(@RequestParam Map<String,Object> params, Model model){
        log.info("call checkPassword");
        String password = params.get("password").toString();
        Long board_id = Long.valueOf(params.get("board").toString());
        int result = boardService.checkPassword(params.get("password").toString(), board_id);
        if(result == 0){
            return true;
        }else{
            return false;
        }
    }


}
