package com.bswen.multids.dao;

import com.bswen.multids.domain.Department;
import com.bswen.multids.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by xx on 2017-1-13.
 *
 * @author xx
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestUserDao {
    @Autowired
    private UserDao userDao;

    @Test
    public void testQueryUsers() {
        List<User> users = userDao.queryUsers();
        assertNotNull(users);
        assertTrue(users.size()>0);
    }

    @Test
    public void testQueryDeparts() {
        List<User> users = userDao.queryUsers();
        for(User user:users) {
            Department department = userDao.queryDepartment(user.getDepartId());
            assertNotNull(department);
        }
    }
}
