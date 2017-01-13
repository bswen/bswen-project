package com.bswen.multids.dao;

import com.bswen.multids.domain.Department;
import com.bswen.multids.domain.User;
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
 * Created by  on 2017-1-13.
 *
 * @author xxx
 */
@Component
public class UserDao {
    private static Log log = LogFactory.getLog(UserDao.class);
    @Autowired
    @Qualifier("jdbcMaster")
    private JdbcTemplate jdbcTemplate;
    @Autowired
    @Qualifier("jdbcSecondary")
    private JdbcTemplate jdbcTemplate2;

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
                        user.setId(rs.getInt("id"));
                        user.setName(rs.getString("name"));
                        user.setPubDate(rs.getDate("pub_date"));
                        user.setDepartId(rs.getInt("depart_id"));
                        return user;
                    }
                });
    }

    /**
     * query
     * @return
     */
    public Department queryDepartment(int departId) {
        String sql = "select * from TBL_DEPARTS where id=?";
        return jdbcTemplate2.queryForObject(
                sql, new RowMapper<Department>() {
                    @Override
                    public Department mapRow(ResultSet rs, int i) throws SQLException {
                        Department department = new Department();
                        department.setId(rs.getInt("id"));
                        department.setName(rs.getString("name"));
                        return department;
                    }
                }, departId);
    }
}
