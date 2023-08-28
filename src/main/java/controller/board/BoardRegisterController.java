package controller.board;

import command.BoardCommand;
import model.board.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import service.board.BoardRegisterService;
import service.board.BoardService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;


@Controller
@RequestMapping("/board/register")
public class BoardRegisterController {
    @Autowired
    private BoardRegisterService registerService;

    @Autowired
    private BoardService boardService;

    @GetMapping
    public String registerForm(@ModelAttribute("formData") BoardCommand brdReq) {
        return "board.register";
    }

    @PostMapping
    public String registerSubmit(@ModelAttribute("formData") @Valid BoardCommand brdReq, Errors errors, HttpServletRequest request) {
        if (errors.hasErrors()) return "board.register";
        registerService.write(brdReq, request);
        return "redirect:/board";
    }
}
