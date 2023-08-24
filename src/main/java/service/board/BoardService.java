package service.board;

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

    public Page<Board> findBoardList(Pageable pageable) {
        return boardRepository.findAll(pageable);
    }
}
