package com.bswen.sbih.dao;

import com.bswen.sbih.domain.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by xxx on 2018/4/25.
 */
@Component
public class CityDao {
    @Autowired
    @Qualifier("jdbcIgnite")
    private JdbcTemplate jdbcTemplateObject;

    public City getCity(Integer id) {
        String SQL = "select * from CITY where ID = ?";
        City city = jdbcTemplateObject.queryForObject(SQL,
                new Object[]{id}, new CityMapper());

        return city;
    }
    public List<City> getCities() {
        String SQL = "select * from CITY";
        List<City> students = jdbcTemplateObject.query(SQL, new CityMapper());
        return students;
    }

    class CityMapper implements RowMapper<City> {
        @Override
        public City mapRow(ResultSet rs, int rowNum) throws SQLException {
            City student = new City();
            student.setId(rs.getInt("ID"));
            student.setName(rs.getString("NAME"));

            return student;
        }
    }
}
