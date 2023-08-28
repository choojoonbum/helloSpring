package service.board;

import command.BoardCommand;
import common.SessionUtil;
import model.board.Board;
import model.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repository.board.BoardRepository;
import repository.user.UserRepository;
import service.auth.AuthInfo;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class BoardRegisterService {

    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private BoardService boardService;

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public void write(BoardCommand brdReq, HttpServletRequest request) {
        AuthInfo authInfo = (AuthInfo) SessionUtil.getSession().getAttribute("authInfo");
        Optional<User> user = userRepository.findById(authInfo.getUserNo());
        Board board = Board.builder()
                .title(brdReq.getTitle())
                .user(user.get())
                .content(brdReq.getContent())
                .createDate(LocalDateTime.now())
                .build();
        boardRepository.save(board);
        boardService.attchFile(brdReq.getMultiFileList(), request, board);
    }
}
