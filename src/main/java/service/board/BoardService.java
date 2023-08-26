package service.board;

import command.BoardCommand;
import model.board.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import repository.board.BoardRepository;

@Service
public class BoardService {
    @Autowired
    private BoardRepository boardRepository;

    public Page<Board> getBoardList(Pageable pageable) {
        return boardRepository.findAll(pageable);
    }

    public Board getBoard(Long brdNo, Boolean visitIncremet) {
        Board board = getBoard(brdNo);
        if (visitIncremet && board != null) {
            board.setVisitCount(board.getVisitCount() + 1);
            boardRepository.save(board);
        }
        return board;
    }

    public Board getBoard(Long brdNo) {
        Board board = boardRepository.findByBoardNo(brdNo);
        return board;
    }

    public Board setBoard(Long brdNo, BoardCommand brdReq) {
        Board board = getBoard(brdNo);
        board.setTitle(brdReq.getTitle());
        board.setContent(brdReq.getContent());
        boardRepository.save(board);
        return board;
    }

    public void remove(Long brdNo) {
        boardRepository.deleteById(brdNo);
    }
}
