package service.board;

import command.BoardCommand;
import common.SessionUtil;
import model.board.Board;
import model.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.board.BoardRepository;
import repository.user.UserRepository;
import service.auth.AuthInfo;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class BoardRegisterService {

    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private UserRepository userRepository;

    public void write(BoardCommand req) {
        AuthInfo authInfo = (AuthInfo) SessionUtil.getSession().getAttribute("authInfo");
        Optional<User> user = userRepository.findById(authInfo.getUserNo());

        Board board = Board.builder().title(req.getTitle()).user(user.get())
                .content(req.getContent()).createDate(LocalDateTime.now()).build();
        boardRepository.save(board);
    }
}
