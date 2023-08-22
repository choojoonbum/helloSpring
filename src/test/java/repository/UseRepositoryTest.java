package repository;

import command.UserRegisterCommand;
import config.DBconfig;
import config.SpringConfig;
import config.WebMvcConfig;
import model.user.User;
import model.user.UserInfo;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.jdbc.JdbcTestUtils;
import repository.user.UserRepository;
import service.user.UserRegisterService;


import javax.sql.DataSource;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.hamcrest.core.IsNull.nullValue;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {DBconfig.class, SpringConfig.class})
public class UseRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserRegisterService userRegisterService;

    @Autowired
    private DataSource dataSource;

    private JdbcTemplate jdbcTemplate;

    @Before
    public void setUp() throws Exception {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Test
    public void save() throws Exception {
        UserRegisterCommand cmd = new UserRegisterCommand();
        cmd.setUserId("cjb99cc00");
        cmd.setPassword("cjb99cc00");
        cmd.setConfirmPassword("cjb99cc00");
        cmd.setEmail("cjb99cc00");
        cmd.setName("cjb99cc00");
        userRegisterService.join(cmd);

        //int count = JdbcTestUtils.countRowsInTableWhere(jdbcTemplate, "user", "email = 'cjb333@nate.com'");
        //assertThat(count, equalTo(1));
    }
}