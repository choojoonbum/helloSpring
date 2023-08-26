package repository;

import command.BoardCommand;
import command.UserRegisterCommand;
import config.DBconfig;
import config.SpringConfig;
import model.board.Board;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.jdbc.JdbcTestUtils;
import repository.board.BoardRepository;
import repository.user.UserRepository;
import service.board.BoardRegisterService;
import service.board.BoardService;
import service.user.UserRegisterService;

import javax.sql.DataSource;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {DBconfig.class, SpringConfig.class})
public class BoardRepositoryTest {

    @Autowired
    BoardRegisterService boardRegisterService;
    @Autowired
    BoardService boardService;

    @Autowired
    BoardRepository boardRepository;
    @Autowired
    private DataSource dataSource;

    private JdbcTemplate jdbcTemplate;

    @Before
    public void setUp() throws Exception {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Test
    public void list() throws Exception {
        //Page<Board> boardPage = boardService.findBoardList();

        //List<Board> boards = boardPage.getContent();
        //System.out.println(boardPage.getTotalPages());
        //System.out.println(boardPage.getSize());
        //boards.forEach(System.out::println);

    }

    @Test
    public void save() throws Exception {
        //for (int i = 0; i < 100; i++ ){
        //    BoardCommand cmd = new BoardCommand();
        //    cmd.setContent("테스트글 내용 " + i + " !!");
        //    cmd.setTitle("테스트글 제목" + i + " !!");
        //    boardRegisterService.write(cmd);
        //}


        //int count = JdbcTestUtils.countRowsInTableWhere(jdbcTemplate, "board", "title = '테스트글 제목'");
       //assertThat(count, equalTo(1));
    }

    @Test
    public void view22() throws Exception {
        Board board = boardRepository.findByBoardNo(Long.valueOf(102));
        board.setVisitCount(1);        
        System.out.println(board);
        System.out.println("test!!!!");

    }
}