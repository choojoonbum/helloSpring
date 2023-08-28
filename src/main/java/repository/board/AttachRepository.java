package repository.board;

import model.board.Attach;
import model.board.Board;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AttachRepository extends JpaRepository<Attach, Long> {
    List<Attach> findByBoard(Board board);
}
