package controller.board;

import exception.BoardNotFoundException;
import model.board.Board;
import org.springframework.beans.TypeMismatchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import service.board.BoardService;


@Controller
public class BoardViewController {
    @Autowired
    private BoardService boardService;

    @GetMapping("/board/view/{id}")
    public String detail(@PathVariable("id") Long brdId, Model model) {
        Board board = boardService.getBoard(brdId, true);
        if (board == null) throw new BoardNotFoundException();
        model.addAttribute("board", board);
        return "board.view";
    }

    @ExceptionHandler(TypeMismatchException.class)
    public String handleTypeMismatchException() {
        return "error/noBoard";
    }

    @ExceptionHandler(BoardNotFoundException.class)
    public String handleNotFoundException() {
        return "error/noBoard";
    }

}
