package controller.board;

import command.BoardCommand;
import model.board.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import service.board.BoardService;

import javax.validation.Valid;

@Controller
@RequestMapping("/board/modify/{id}")
public class BoardModifiyController {
    @Autowired
    private BoardService boardService;

    @GetMapping
    public String modifiyForm(@PathVariable("id") Long brdNo, Model model) {
        Board board = boardService.getBoard(brdNo);
        model.addAttribute("formData", new BoardCommand(board.getTitle(),board.getContent()));
        return "board.modify";
    }

    @PostMapping
    public String modifiySubmit(@PathVariable("id") Long brdNo, @ModelAttribute("formData") @Valid BoardCommand brdReq, Errors errors, Model model) {
        if (errors.hasErrors()) return "board.modify";
        boardService.setBoard(brdNo, brdReq);
        return "redirect:/board/view/" + brdNo;
    }
}
