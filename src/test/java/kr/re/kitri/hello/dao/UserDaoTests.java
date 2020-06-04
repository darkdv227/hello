package kr.re.kitri.hello.dao;

import static org.junit.jupiter.api.Assertions.*;

import kr.re.kitri.hello.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class UserDaoTests {

    @Autowired
    private UserDao userDao;

    @Test
    public void testSelectAllUsers() {
        List<User> users = userDao.selectAllUsers();
        assertTrue(users.size() > 0);

    }

    @Test
    public void testSelectUserByUserId() {
        User user = userDao.selectUserByUserId("ryu");
        assertEquals("hyunjin", user.getName());
    }
}
