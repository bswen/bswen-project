package sba.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import sba.domain.Student;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by xxx on 2018/4/25.
 */
@Component
public class StudentDao {
    @Autowired
    private JdbcTemplate jdbcTemplateObject;

    public Student getStudent(Integer id) {
        String SQL = "select * from tbl_student where id = ?";
        Student student = jdbcTemplateObject.queryForObject(SQL,
                new Object[]{id}, new StudentMapper());

        return student;
    }

    class StudentMapper implements RowMapper<Student> {
        @Override
        public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
            Student student = new Student();
            student.setId(rs.getInt("id"));
            student.setName(rs.getString("name"));

            return student;
        }
    }
}
