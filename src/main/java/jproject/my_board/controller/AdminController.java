package jproject.my_board.controller;

import lombok.Getter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller("/admin")
public class AdminController {

    @GetMapping("/main")
    public String adminMain(){
        return "admin_main";
    }
}
