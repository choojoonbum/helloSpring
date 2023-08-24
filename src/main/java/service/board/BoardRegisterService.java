package service.board;

import command.BoardCommand;
import model.board.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.board.BoardRepository;

import java.time.LocalDateTime;

@Service
public class BoardRegisterService {

    @Autowired
    private BoardRepository boardRepository;

    public void write(BoardCommand req) {
        Board board = Board.builder().title(req.getTitle()).
                content(req.getContent()).createDate(LocalDateTime.now()).build();
        boardRepository.save(board);
    }
}
