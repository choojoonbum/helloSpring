package controller.board;

import command.BoardCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import service.board.BoardRegisterService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;

@Controller
@RequestMapping("/board/register")
public class BoardRegisterController {
    @Autowired
    private BoardRegisterService registerService;

    @GetMapping
    public String registerForm(@ModelAttribute("formData") BoardCommand brdReq) {
        return "board.register";
    }

    @PostMapping
    public String registerSubmit(@ModelAttribute("formData") @Valid BoardCommand brdReq, Errors errors) {
        if (errors.hasErrors()) return "board.register";
        registerService.write(brdReq);
        return "redirect:/board";
    }
}
