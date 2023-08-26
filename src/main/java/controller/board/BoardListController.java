package controller.board;

import common.Pagination;
import model.board.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import service.board.BoardService;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/board")
public class BoardListController {
    @Autowired
    private BoardService boardService;

    @GetMapping({"", "/"})
    public String findBoardList(@PageableDefault(sort = "boardNo", direction = Sort.Direction.DESC) Pageable pageable, Model model, HttpServletRequest request) {
        Page<Board> pageBoard = boardService.getBoardList(pageable);
        model.addAttribute("boardList", pageBoard);
        model.addAttribute("pagingStr", Pagination.pagingStr(pageBoard, 5, request.getContextPath() + "/board"));
        return "board.list";
    }

}
