package com.bswen.sbut.mockdao.dao;

import com.bswen.sbut.mockdao.domain.User;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by zhaocaiwen on 2017/1/24.
 */
@Component
public class MyDao {
    private static Log log = LogFactory.getLog(MyDao.class);
    @Autowired
    @Qualifier("jdbcMaster")
    private JdbcTemplate jdbcTemplate;

    private List<User> userList;

    /**
     * query
     * @return
     */
    public List<User> queryUsers() {
        String sql = "select * from TBL_USERS";
        return this.jdbcTemplate.query(
                sql, new Object[]{},
                new RowMapper<User>() {
                    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                        User user = new User();
                        user.setName(rs.getString("name"));
                        return user;
                    }
                });
    }

}
