package controller.board;

import exception.BoardNotFoundException;
import model.board.Attach;
import model.board.Board;
import org.springframework.beans.TypeMismatchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import service.board.BoardService;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Controller
public class BoardViewController {
    @Autowired
    private BoardService boardService;

    @GetMapping("/board/view/{id}")
    public String detail(@PathVariable("id") Long brdId, Model model) {
        Board board = boardService.getBoard(brdId, true);
        List<Attach> attachList = boardService.getAttach(board);
        if (board == null) throw new BoardNotFoundException();
        model.addAttribute("board", board);
        model.addAttribute("attachList", attachList);
        return "board.view";
    }

    @GetMapping("/display")
    public ResponseEntity<Resource> display(@RequestParam("filename") String fileName, HttpServletRequest request) {
        return boardService.getImgResponse(fileName, request);
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
