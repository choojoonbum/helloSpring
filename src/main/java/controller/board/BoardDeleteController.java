package controller.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import service.board.BoardService;

@Controller
public class BoardDeleteController {
    @Autowired
    BoardService boardService;

    @RequestMapping("/board/remove/{id}")
    public String delete(@PathVariable("id") Long brdNo) {
        boardService.remove(brdNo);
        return "redirect:/board";
    }
}
