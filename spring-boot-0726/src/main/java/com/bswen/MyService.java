package com.bswen;

import com.bswen.dao.UserDao;
import com.bswen.domain.User;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: bswen
 * Date: 15-7-26
 * Time: 下午10:49
 * To change this template use File | Settings | File Templates.
 */
@Component
public class MyService implements CommandLineRunner {
    static Log log = LogFactory.getLog(MyService.class);

    @Autowired
    private UserDao userDao;

    @Override
    public void run(String... strings) throws Exception {
        try {
            while(true) {
                Thread.sleep(2*1000);
                List<User> users = userDao.queryUsers();
                log.debug("MySQL db has "+(users==null?0:users.size())+" users.");
            }
        }catch (Exception ex) {
             log.error("Error occurred.",ex);
        }
    }
}
